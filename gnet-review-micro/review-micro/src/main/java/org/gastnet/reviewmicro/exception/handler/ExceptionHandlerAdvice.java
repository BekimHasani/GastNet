package org.gastnet.reviewmicro.exception.handler;

import org.gastnet.reviewmicro.exception.NotFoundException;
import org.gastnet.reviewmicro.exception.ValidationException;
import org.gastnet.reviewmicro.exception.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException exc) {
        ExceptionResponse excResponse = new ExceptionResponse(exc.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(excResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ExceptionResponse> handleValidationException(ValidationException exc) {
        ExceptionResponse excResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST, exc.getErrors());
        return new ResponseEntity<>(excResponse, HttpStatus.BAD_REQUEST);
    }
}

