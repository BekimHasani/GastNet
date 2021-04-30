package org.gastnet.businessmicro.validator;

import org.apache.commons.lang3.StringUtils;
import org.gastnet.businessmicro.entity.Business;
import org.gastnet.businessmicro.enumeration.Category;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BusinessValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Business.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Business business = (Business) target;
		String charOnly = "[A-Za-z\\s]+";

		String name = business.getName();
		if (StringUtils.isEmpty(name)) {
			errors.rejectValue("name","Name cannot be empty");
		} else if (!name.matches(charOnly)) {
			errors.rejectValue("name","Name must contain only characters");
		} else if(name.length() < 3 || name.length() > 40){
			errors.reject("name","Name must contain more than 3 and less than 40 characters");
		}

		String businessNumber = business.getBusinessNumber();
		if(StringUtils.isEmpty(businessNumber)) {
			errors.rejectValue("businessNumber","Business number cannot be empty");
		} else if (StringUtils.isAlphaSpace(businessNumber)) {
			errors.rejectValue("businessNumber","Business number should contain only number");
		} else if (businessNumber.length() < 3 || businessNumber.length() > 40) {
			errors.reject("businessNumber","Business number must contain more than 3 and less than 40 numbers");
		}

		Category category = business.getCategory();
		if (category == null) {
			errors.rejectValue("category", "Category is required");
		}

	}

}
