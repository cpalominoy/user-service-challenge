package com.nisum.userservicechallenge.shared.constraint.email;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailFormatConstraintValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailFormatConstraint {

  String message() default "Email no cumple con el formato";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
