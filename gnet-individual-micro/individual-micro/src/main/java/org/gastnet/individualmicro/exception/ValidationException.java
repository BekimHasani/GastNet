package org.gastnet.individualmicro.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 877738738196963770L;
	private Map<String,String> errors;

	public ValidationException(String message, Map<String,String> errors) {
		super(message);
		this.errors = errors;
	}

	public Map<String,String>  getErrors() {
		return errors;
	}

	public void setErrors(Map<String,String> errors) {
		this.errors = errors;
	}
}
