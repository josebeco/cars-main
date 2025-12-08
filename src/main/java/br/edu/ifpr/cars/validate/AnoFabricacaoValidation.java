package br.edu.ifpr.cars.validate;

import java.time.LocalDate;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class AnoFabricacaoValidation implements ConstraintValidator<AnoFabricacaoValido, Integer>{

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
    return value >= 1886 && value <= LocalDate.now().getYear();
    }

}
