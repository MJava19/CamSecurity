package ua.lviv.lgs.CamSecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.lviv.lgs.CamSecurity.entity.Role;
import ua.lviv.lgs.CamSecurity.entity.ShoppingBasket;
import ua.lviv.lgs.CamSecurity.entity.User;
import ua.lviv.lgs.CamSecurity.repository.RoleRepository;
import ua.lviv.lgs.CamSecurity.servise.ShoppingBasketServise;
import ua.lviv.lgs.CamSecurity.servise.UserServise;
import ua.lviv.lgs.CamSecurity.servise.impl.UserDTO;
import ua.lviv.lgs.CamSecurity.validator.UserUpdateValidator;
import ua.lviv.lgs.CamSecurity.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserServise userServise;
    private final ShoppingBasketServise basketServise;
    private final RoleRepository roleRepository;
    private final UserValidator userValidator;
    private final UserUpdateValidator updateValidator;


    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") UserDTO userDTO, BindingResult bindingResult) {
        User user = mapToEntity(userDTO);
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        basketServise.create(shoppingBasket);
        user.setShoppingBasket(shoppingBasket);
        user.getRoles().add(roleRepository.findByName("ROLE_USER"));
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userServise.save(user);
        return "redirect:/login";
    }

    private User mapToEntity(UserDTO userDTO) {
        User rezult = new User();
        rezult.setId(userDTO.getId());
        rezult.setUsername(userDTO.getUsername());
        rezult.setFirstName(userDTO.getFirstName());
        rezult.setLastName(userDTO.getLastName());
        rezult.setEmail(userDTO.getEmail());
        rezult.setPassword(userDTO.getPassword());
        try {
            rezult.setBase64(Base64.getEncoder().encodeToString(userDTO.getAvatar().getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            rezult.setAvatar(userDTO.getAvatar().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rezult;
    }

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        model.addAttribute("userForm", new UserDTO());
        return "registration";
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/user/edit")
    public String userEditPage(Model model, HttpServletRequest request){
            User user = userServise.findByUsername(request.getUserPrincipal().getName());
            user.setPassword("");
            model.addAttribute("userForm", user);
            return "update-user";
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping("/user/edit")
    public String updateUser(@ModelAttribute("userForm") UserDTO userDTO, HttpServletRequest request, BindingResult bindingResult) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = mapToEntity(userDTO);
        User userForId = userServise.findByUsername(request.getUserPrincipal().getName());
        if (passwordEncoder.matches(user.getPassword(), userForId.getPassword())) {
            user.setId(userForId.getId());
            user.setShoppingBasket(userForId.getShoppingBasket());
            List<Role> roleList = new ArrayList<>();
            roleList.addAll(userForId.getRoles());
            for (int i = 0; i < roleList.size(); i++) {
                user.getRoles().add(roleList.get(i));
            }
            updateValidator.validate(user, bindingResult);
            if (bindingResult.hasErrors()) {
                return "redirect:/user/edit";
            }
            userServise.save(user);
            return "redirect:/";
        }
        return "redirect:/user/edit";
    }
}
