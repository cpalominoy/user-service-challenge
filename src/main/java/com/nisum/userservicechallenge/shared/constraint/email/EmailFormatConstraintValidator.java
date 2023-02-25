package com.nisum.userservicechallenge.shared.constraint.email;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Value;

public class EmailFormatConstraintValidator
    implements ConstraintValidator<EmailFormatConstraint, String> {

  @Value("${regexp.email}")
  private String emailRegexp;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return Pattern.compile(emailRegexp).matcher(value).matches();
  }
}
