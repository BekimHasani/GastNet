package org.gastnet.individualmicro.exception.response;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class ValidationExceptionResponse {

	private int status;
	private LocalDateTime timestamp;
	private Map<String,String> errors;

	public ValidationExceptionResponse() {
	}

	public ValidationExceptionResponse(HttpStatus status, Map<String,String> errors) {
		this.status = status.value();
		this.errors = errors;
		this.timestamp = LocalDateTime.now();
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	
}
