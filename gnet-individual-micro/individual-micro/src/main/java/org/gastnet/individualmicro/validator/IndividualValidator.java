package org.gastnet.individualmicro.validator;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import org.gastnet.individualmicro.entity.Individual;
import org.gastnet.individualmicro.enumeration.IndividualType;
import org.gastnet.individualmicro.utils.ValidationUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class IndividualValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Individual.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Individual individual = (Individual)target;
		String charOnly = "[A-Za-z]+";
		String name = individual.getName();
		String lastName = individual.getLastName();;
		String phoneNumber = individual.getPhoneNumber();
		IndividualType individualType = individual.getIndividualType();
		Date birthDate = individual.getBirthDate();
		
		if(ValidationUtils.isTrimedEmpty(name)) {
			errors.rejectValue("name","Name cannot be empty");
		}else if (!name.matches(charOnly)) {
			errors.rejectValue("name","Name must contain only characters");
		}else if(name.length() < 3 || name.length() > 40){
			errors.reject("name","Name must contain more than 3 and less than 40 characters");
		}
		
		if(ValidationUtils.isTrimedEmpty(lastName)) {
			errors.rejectValue("lastName","Last name cannot be empty");
		}else if (!lastName.matches(charOnly)) {
			errors.rejectValue("lastName","Last name must contain only characters");
		}else if(lastName.length() < 3 || lastName.length() > 40){
			errors.reject("lastName","Last name must contain more than 3 and less than 40 characters");
		}
		
		if(birthDate == null) {
			errors.rejectValue("birthDate", "Birth date cannot be empty");
		}else {
			LocalDate dateNow = LocalDate.now();
			LocalDate inputDate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			Period period = Period.between(inputDate, dateNow);
			if(inputDate.isAfter(dateNow)) {
				errors.rejectValue("birthDate", "Invalid birth date");
			}else if(period.getYears() < 18) {
				errors.rejectValue("birthDate", "Must be at least 18 years old");
			}else if (period.getYears() > 63) {
				errors.rejectValue("birthDate", "Invalid birth date");
			}
		}		
		
		if(!(individual.getGender()+"").matches("^[M|F]{1}$")) {
			errors.rejectValue("gender", "Please choose gender");
		}
		
		if(ValidationUtils.isTrimedEmpty(phoneNumber)) {
			errors.rejectValue("phoneNumber", "Phone number cannot be empty");
		}else if(!phoneNumber.matches("[0-9]+")){
			errors.rejectValue("phoneNumber", "Phone number can contain only numbers");
		}else if(phoneNumber.length() < 9 || phoneNumber.length() > 30) {
			errors.rejectValue("phoneNumber", "Phone number must contain more than 9 and less than 30 characters");
		}
		
		if(individualType == null) {
			errors.rejectValue("individualType", "Please choose individual type");
		}
		
	}
	
	

}
