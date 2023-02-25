package com.nisum.userservicechallenge.shared.exception.handler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import com.nisum.userservicechallenge.shared.exception.HttpMessageResponse;
import com.nisum.userservicechallenge.shared.exception.UserAlreadyExistsException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalCustomRestExceptionHandler implements ErrorController {

  @ExceptionHandler(UserAlreadyExistsException.class)
  public ResponseEntity<HttpMessageResponse> userAlreadyExistsException(
      UserAlreadyExistsException exception) {
    return createHttpMessageResponse(BAD_REQUEST, exception.getMessage());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {

    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult()
        .getAllErrors()
        .forEach(
            (error) -> {
              String fieldName = ((FieldError) error).getField();
              String errorMessage = error.getDefaultMessage();
              errors.put(fieldName, errorMessage);
            });
    return errors;
  }

  private ResponseEntity<HttpMessageResponse> createHttpMessageResponse(
      HttpStatus httpStatus, String message) {
    return new ResponseEntity<>(new HttpMessageResponse(message), httpStatus);
  }
}
