package com.nisum.userservicechallenge.shared.constraint.password;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Value;

public class PasswordFormatConstraintValidator
    implements ConstraintValidator<PasswordFormatConstraint, String> {

  @Value("${regexp.password}")
  private String passwordRegexp;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return Pattern.compile(passwordRegexp).matcher(value).matches();
  }
}
