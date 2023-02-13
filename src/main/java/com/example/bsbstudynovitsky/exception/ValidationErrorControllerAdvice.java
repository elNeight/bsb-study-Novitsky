package com.example.bsbstudynovitsky.exception;

import com.example.bsbstudynovitsky.dto.validation.ValidationErrorResponse;
import com.example.bsbstudynovitsky.dto.validation.Violation;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ValidationErrorControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        List<Violation> violations = e.getBindingResult().getFieldErrors().stream()
                .map(error -> new Violation(error.getField(), error.getDefaultMessage()))
                .toList();

        return new ValidationErrorResponse(violations);
    }

}
