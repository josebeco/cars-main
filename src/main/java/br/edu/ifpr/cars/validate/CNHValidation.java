package br.edu.ifpr.cars.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class CNHValidation implements ConstraintValidator<CNHValida, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return (!value.isEmpty()) && value.matches("\\d{11}");
    }

}
