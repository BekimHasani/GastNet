package org.gastnet.usermicro.exception.handler;

import org.gastnet.usermicro.exception.ValidationException;
import org.gastnet.usermicro.exception.response.ValidationExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ValidationExceptionResponse> handleValidationException(ValidationException ex){
    	ValidationExceptionResponse response = new ValidationExceptionResponse(HttpStatus.BAD_REQUEST, ex.getErrors());
    	return new ResponseEntity<ValidationExceptionResponse>(response,HttpStatus.BAD_REQUEST);
    }
    
}