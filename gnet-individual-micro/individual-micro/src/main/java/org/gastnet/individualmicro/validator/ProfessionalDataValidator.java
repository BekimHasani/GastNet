package org.gastnet.individualmicro.validator;

import java.util.Date;

import org.gastnet.individualmicro.entity.Individual;
import org.gastnet.individualmicro.entity.ProfessionalData;
import org.gastnet.individualmicro.enumeration.ActivityType;
import org.gastnet.individualmicro.utils.ValidationUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProfessionalDataValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(ProfessionalData.class) || clazz.equals(Individual.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (target instanceof ProfessionalData) {
			ProfessionalData professionalData = (ProfessionalData) target;
			String title = professionalData.getTitle();
			Date startDate = professionalData.getStartDate();
			Date endDate = professionalData.getEndDate();
			ActivityType activityType = professionalData.getActivityType();

			if (ValidationUtils.isTrimedEmpty(title)) {
				errors.rejectValue("title", "Title cannot be empty");
			}

			if (startDate == null) {
				errors.rejectValue("startDate", "Please choose start date");
			} else if (startDate.after(new Date())) {
				errors.rejectValue("startDate", "Invalid start date");
			} else if (ValidationUtils.isValidWorkingStartDate(startDate,
					professionalData.getIndividual().getBirthDate())) {
				errors.rejectValue("startDate", "Start date must be at least starting from 8 years");
			}

			if (endDate != null) {
				if (endDate.after(new Date())) {
					errors.rejectValue("endDate", "Invalid end date");
				} else if (startDate != null && endDate.before(startDate)) {
					errors.rejectValue("endDate", "End date cannot be before startDate");
				}
			}

			if (activityType == null) {
				errors.rejectValue("activityType", "Please select type");
			}
		}
	}
}
