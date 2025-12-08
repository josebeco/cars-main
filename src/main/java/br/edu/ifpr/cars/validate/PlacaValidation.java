package br.edu.ifpr.cars.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class PlacaValidation implements ConstraintValidator<PlacaValida, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("^[A-Z]{3}[0-9][A-Z][0-9]{2}$");
    }

}
