package com.career.setup.portfolio.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
@Slf4j
public class PortfolioExceptionHandler {
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<BadRequestException> handleMissingRequestBody(HttpMessageNotReadableException exception) {
        log.error("Missing request body exception", exception.getMessage());
        return new ResponseEntity<>(new BadRequestException(exception.getMessage()), BAD_REQUEST);
    }
}
