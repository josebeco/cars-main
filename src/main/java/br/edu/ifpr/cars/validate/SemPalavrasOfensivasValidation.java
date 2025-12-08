package br.edu.ifpr.cars.validate;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;




public class SemPalavrasOfensivasValidation implements ConstraintValidator<SemPalavrasOfensivas, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String[] badWords = {"burro", "idiota", "lixo"};

        value = value.toLowerCase();
        for(String bad : badWords){
            if(value.contains(bad)){
                return false;
            }
        }
        
        return true;
    }

}
