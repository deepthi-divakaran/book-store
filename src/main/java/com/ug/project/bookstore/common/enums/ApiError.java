package com.ug.project.bookstore.common.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ApiError {

    BOOK_NOT_FOUND("Book not found", HttpStatus.NOT_FOUND),

    USER_NOT_FOUND("User not found", HttpStatus.NOT_FOUND),

    USER_ALREADY_EXISTS("User already exists", HttpStatus.ALREADY_REPORTED),

    EMAIL_ALREADY_EXISTS("Email already exists", HttpStatus.ALREADY_REPORTED),

    ITEM_NOT_FOUND("Item not found", HttpStatus.NOT_FOUND);

    private final String message;
    private final HttpStatus status;

    ApiError(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
