package ua.lviv.lgs.CamSecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.lviv.lgs.CamSecurity.entity.User;
import ua.lviv.lgs.CamSecurity.servise.UserServise;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class WelcomeController {
    private final UserServise userServise;

    @Secured("ROLE_USER")
    @GetMapping
    public  String home(HttpServletRequest request, Model model) {
        model.addAttribute("message", userServise.findByUsername(request.getUserPrincipal().getName()));
        return "home";
    }
}
