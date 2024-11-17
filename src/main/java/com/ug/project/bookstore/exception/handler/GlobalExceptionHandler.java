package com.ug.project.bookstore.exception.handler;

import com.ug.project.bookstore.exception.ApiFailedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiFailedException.class)
    public ResponseEntity<String> handleApiFailedException(ApiFailedException ex) {
        return new ResponseEntity<>(ex.getMessage(), ex.getStatus());
    }
}
