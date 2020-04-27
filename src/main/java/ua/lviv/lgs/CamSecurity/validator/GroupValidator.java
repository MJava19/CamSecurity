package ua.lviv.lgs.CamSecurity.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.lviv.lgs.CamSecurity.entity.Groups;

@Component
public class GroupValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Groups.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Groups groups = (Groups) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name", "Not empty", "Це обов'язкове поле для заповнення!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"description", "Not empty", "Це обов'язкове поле для заповнення!");
    }
}

