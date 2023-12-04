package com.backend.microservices.blogservice.exception;

public class NoBlogPresentException extends RuntimeException {
    public NoBlogPresentException(String noBlogPresentMessage) {
        super(noBlogPresentMessage);
    }
}
