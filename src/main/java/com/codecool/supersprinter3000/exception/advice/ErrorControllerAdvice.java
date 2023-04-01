package com.codecool.supersprinter3000.exception.advice;

import com.codecool.supersprinter3000.exception.DeveloperNotFoundException;
import com.codecool.supersprinter3000.exception.UserStoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(value = { DeveloperNotFoundException.class, UserStoryNotFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ErrorResponse handleNoDeveloper(RuntimeException ex) {
        return new ErrorResponse(ex.getMessage());
    }

    private record ErrorResponse(String errorMessage) {
    }
}