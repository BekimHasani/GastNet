package org.gastnet.clientmicro.util;

import org.gastnet.clientmicro.model.ValidationErrors;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidationUtils {
	private ValidationUtils() {}
	
	@SuppressWarnings("unchecked")
	public static <T> void addValidationErrors(T t, BindingResult bindingResult) {
		try {
			ResponseEntity<ValidationErrors> errorResponse = (ResponseEntity<ValidationErrors>) t;
			log.info("Response returned " + errorResponse.getStatusCodeValue() + " HTTP status, adding validation errors");
			errorResponse.getBody().getErrors().entrySet().stream().forEach(error -> {
				bindingResult.rejectValue(error.getKey(), error.getKey(), error.getValue());
			});
		} catch (Exception e) {
			log.error("Exception " + e.getMessage());
		}
	}
	

}
