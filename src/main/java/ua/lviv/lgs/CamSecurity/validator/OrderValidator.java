package ua.lviv.lgs.CamSecurity.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.lviv.lgs.CamSecurity.entity.Order;

@Component
public class OrderValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Order.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Order order = (Order) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "Not empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "goodsList", "Not empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "totalGoods", "Not empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "totalPrice", "Not empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "Not empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "Not empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fatherName", "Not empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Not empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "Not empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "region", "Not empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "Not empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberBranch", "Not empty");
    }
}
