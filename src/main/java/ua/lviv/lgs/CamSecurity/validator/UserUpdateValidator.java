package ua.lviv.lgs.CamSecurity.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.lviv.lgs.CamSecurity.entity.User;
import ua.lviv.lgs.CamSecurity.servise.UserServise;

@Component
@RequiredArgsConstructor
public class UserUpdateValidator implements Validator {
    private final UserServise userServise;
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "Not_empty", "Це обов'язкове поле для заповнення!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "Not_empty", "Це обов'язкове поле для заповнення!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Not_empty", "Це обов'язкове поле для заповнення!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Not_empty", "Це обов'язкове поле для заповнення!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Not_empty", "Це обов'язкове поле для заповнення!");
        if (user.getPassword().length() < 8) {
            errors.rejectValue("password", "Size.userForm.password", "Мінімальна довжина пароля 8 символів");
        }
    }
}
