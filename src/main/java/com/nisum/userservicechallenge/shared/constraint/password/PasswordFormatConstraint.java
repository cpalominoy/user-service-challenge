package com.nisum.userservicechallenge.shared.constraint.password;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordFormatConstraintValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordFormatConstraint {

  String message() default "El password no cumple con el formato";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
