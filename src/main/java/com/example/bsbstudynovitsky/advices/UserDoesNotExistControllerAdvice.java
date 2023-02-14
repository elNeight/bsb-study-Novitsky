package com.example.bsbstudynovitsky.advices;

import com.example.bsbstudynovitsky.dto.exception.UserDoesNotExistResponse;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class UserDoesNotExistControllerAdvice {

    @ExceptionHandler({NoSuchElementException.class, EmptyResultDataAccessException.class})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public UserDoesNotExistResponse onNoSuchElementException() {
        return new UserDoesNotExistResponse("No such user");
    }

}
