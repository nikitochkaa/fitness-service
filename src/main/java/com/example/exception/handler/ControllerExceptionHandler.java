package com.example.exception.handler;

import com.example.exception.PasswordNotValidException;
import com.example.exception.UserAlreadyExistsException;
import com.example.exception.UserNotExistException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorResponse handleConstraintViolationException(ConstraintViolationException e) {
        return new ErrorResponseImpl(
            HttpStatus.BAD_REQUEST,
            e.getConstraintViolations().stream().findAny().get().getMessage()
        );
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ErrorResponse handleException(UserAlreadyExistsException e) {
        return new ErrorResponseImpl(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(UserNotExistException.class)
    public ErrorResponse handleException(UserNotExistException e) {
        return new ErrorResponseImpl(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @ExceptionHandler(PasswordNotValidException.class)
    public ErrorResponse handleException(PasswordNotValidException e) {
        return new ErrorResponseImpl(HttpStatus.FORBIDDEN, e.getMessage());
    }

}
