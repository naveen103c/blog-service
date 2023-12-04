package com.backend.microservices.blogservice.exception;

public class DateOfCreationNotValidException extends RuntimeException {
    public DateOfCreationNotValidException(String docNotValid) {
        super(docNotValid);
    }
}
