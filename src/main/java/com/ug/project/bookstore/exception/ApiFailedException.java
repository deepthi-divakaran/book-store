package com.ug.project.bookstore.exception;

import com.ug.project.bookstore.common.enums.ApiError;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiFailedException extends RuntimeException {
    private final HttpStatus status;

    public ApiFailedException(ApiError error) {
        super(error.getMessage());
        this.status = error.getStatus();
    }
}
