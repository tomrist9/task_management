package com.example.user_management.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AuthenticationException.class)
    public ErrorResponse handleAuthenticationException(AuthenticationException e) {
        return new ErrorResponse(HttpStatus.valueOf(401),e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException e) {
        StringBuilder stringBuilder = new StringBuilder();
        e.getBindingResult()
                .getAllErrors()
                .forEach(error -> stringBuilder.append(String.format("%s : %s ",
                        ((FieldError) error).getField(), error.getDefaultMessage())));

        return new ResponseEntity<>(new ErrorResponse(HttpStatus.BAD_REQUEST, stringBuilder.toString()),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND,e.getMessage()),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExistingResourceException.class)
    public ResponseEntity<ErrorResponse> handleResourceAlreadyExistsException(ExistingResourceException e) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.CONFLICT,e.getMessage()),HttpStatus.CONFLICT);
    }

    @ExceptionHandler(OTPCodeExpiredException.class)
    public ResponseEntity<ErrorResponse> handleOTPSessionExpiredException(OTPCodeExpiredException e) {
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND,e.getMessage()),HttpStatus.NOT_FOUND);
    }

}
