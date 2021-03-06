package ua.lviv.lgs.CamSecurity.validator;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.lviv.lgs.CamSecurity.entity.User;
import ua.lviv.lgs.CamSecurity.repository.UserRepository;
import ua.lviv.lgs.CamSecurity.servise.UserServise;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {
    private final UserServise userServise;
    private final UserRepository userRepository;
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Not_empty", "Це обов'язкове поле для заповнення!");

        List<User> userList = new ArrayList<>();
        userList.addAll(userRepository.findAll());
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(user.getUsername())) {
                errors.rejectValue("username", "unique.username", "Цей нік вже зареєстрований! Введіть інший!");
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Not_empty", "Це обов'язкове поле для заповнення!");
        if (user.getPassword().length() < 8) {
            errors.rejectValue("password", "Size.userForm.password", "Мінімальна довжина пароля 8 символів");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Not_empty", "Це обов'язкове поле для заповнення!");

        if (userServise.findByEmail(user.getEmail()) != null){
            errors.rejectValue("email", "unique.email", "Цей email вже зареєстрований! Введіть інший!");
        }
    }
}
