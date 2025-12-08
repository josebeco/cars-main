package br.edu.ifpr.cars.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
@Documented
@Constraint(validatedBy = SemPalavrasOfensivasValidation.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)


public @interface SemPalavrasOfensivas {
    String message() default "Comentario não é válido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
