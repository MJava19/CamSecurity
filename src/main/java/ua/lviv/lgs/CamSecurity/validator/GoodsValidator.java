package ua.lviv.lgs.CamSecurity.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.lviv.lgs.CamSecurity.entity.Goods;

@Component
public class GoodsValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Goods.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Goods goods = (Goods) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "Not empty", "Це обов'язкове поле для заповнення!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Not empty", "Це обов'язкове поле для заповнення!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Not empty", "Це обов'язкове поле для заповнення!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "Not empty", "Це обов'язкове поле для заповнення!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "manufacturer", "Not empty", "Це обов'язкове поле для заповнення!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "image", "Not empty", "Це обов'язкове поле для заповнення!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "group", "Not empty", "Це обов'язкове поле для заповнення!");

    }
}
