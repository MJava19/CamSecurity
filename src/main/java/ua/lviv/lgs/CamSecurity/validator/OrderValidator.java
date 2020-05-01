package ua.lviv.lgs.CamSecurity.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.lviv.lgs.CamSecurity.entity.Order;

import javax.validation.constraints.Pattern;

@Component
public class OrderValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Order.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Order order = (Order) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "Not_empty", "Це обов'язкове поле для заповнення!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "Not_empty", "Це обов'язкове поле для заповнення!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fatherName", "Not_empty", "Це обов'язкове поле для заповнення!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Not_empty", "Це обов'язкове поле для заповнення!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "Not_empty", "Це обов'язкове поле для заповнення!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "region", "Not_empty", "Це обов'язкове поле для заповнення!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "Not_empty", "Це обов'язкове поле для заповнення!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberBranch", "Not_empty", "Це обов'язкове поле для заповнення!");
    }
}
