package org.gastnet.individualmicro.exception.handler;


import org.gastnet.individualmicro.exception.NotFoundException;
import org.gastnet.individualmicro.exception.ValidationException;
import org.gastnet.individualmicro.exception.response.ExceptionResponse;
import org.gastnet.individualmicro.exception.response.ValidationExceptionResponse;
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
    public ResponseEntity<ValidationExceptionResponse> handleValidationException(ValidationException ex){
    	ValidationExceptionResponse response = new ValidationExceptionResponse(HttpStatus.BAD_REQUEST, ex.getErrors());
    	return new ResponseEntity<ValidationExceptionResponse>(response,HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> getException(Exception e){
    	return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
