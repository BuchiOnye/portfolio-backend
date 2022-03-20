package com.career.setup.portfolio.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends AbstractException {
    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
