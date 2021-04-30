package org.gastnet.individualmicro.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;

public class ValidationUtils {
	private ValidationUtils() {}

	public static Map<String,String> getFieldErrors(BindingResult bindingResult){
		return getFieldErrors(bindingResult,null);
	}
	
	public static boolean isTrimedEmpty(String attribute) {
		return StringUtils.isEmpty(attribute) || attribute.trim().isEmpty();
	}

	public static boolean isValidWorkingStartDate(Date startDate,Date birthDate) {
		LocalDate localStartDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate localBirthDate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Period period = Period.between(localStartDate, localBirthDate);
		return period.getYears() >= 8;
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
	