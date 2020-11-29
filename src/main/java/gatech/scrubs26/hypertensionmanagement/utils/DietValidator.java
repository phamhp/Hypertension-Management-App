package gatech.scrubs26.hypertensionmanagement.utils;

import gatech.scrubs26.hypertensionmanagement.model.Diet;
import gatech.scrubs26.hypertensionmanagement.model.User;
import gatech.scrubs26.hypertensionmanagement.service.DietService;
import gatech.scrubs26.hypertensionmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DietValidator implements Validator {
    @Autowired
    private DietService dietService;


    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        Diet diet = (Diet) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fat", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "protein", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "carb", "NotEmpty");
    }
}
