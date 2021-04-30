package org.gastnet.usermicro.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.BindingResult;

public class ValidationUtils {
	private ValidationUtils() {}

	public static Map<String,String> getFieldErrors(BindingResult bindingResult){
		return getFieldErrors(bindingResult,null);
	}	

	public static Map<String,String> getFieldErrors(BindingResult bindingResult, String suffix){
		if(suffix == null) {
			suffix = "";
		}
		String value = suffix;
		Map<String,String> errors = new HashMap<>();
		bindingResult.getFieldErrors().forEach(error -> {
			errors.put(value + error.getField(),error.getCode());
		});
		return errors;
	}
	
}