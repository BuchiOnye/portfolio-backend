package com.career.setup.portfolio.exceptions;

import org.springframework.http.HttpStatus;

public abstract class AbstractException extends RuntimeException {
    protected AbstractException(String message) {
        super(message);
    }

    public abstract HttpStatus getHttpStatus();
}
