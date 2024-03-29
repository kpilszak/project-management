package com.kpilszak.projectmanagement.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValueValidator.class)
public @interface UniqueValueConstraint {

    String message() default "Unique Constraint violated";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
