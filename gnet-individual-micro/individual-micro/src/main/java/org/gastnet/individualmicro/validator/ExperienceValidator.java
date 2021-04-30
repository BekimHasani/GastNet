package org.gastnet.individualmicro.validator;

import java.util.Date;

import org.gastnet.individualmicro.entity.Experience;
import org.gastnet.individualmicro.entity.Individual;
import org.gastnet.individualmicro.enumeration.JobTitle;
import org.gastnet.individualmicro.utils.ValidationUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ExperienceValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Experience.class) || clazz.equals(Individual.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (target instanceof Experience) {
			Experience experience = (Experience) target;
			Date startDate = experience.getStartDate();
			Date endDate = experience.getEndDate();
			JobTitle jobTitle = experience.getJobTitle();

			if (startDate == null) {
				errors.rejectValue("startDate", "Please choose start date");
			} else if (startDate.after(new Date())) {
				errors.rejectValue("startDate", "Invalid start date");
			} else if (ValidationUtils.isValidWorkingStartDate(startDate, experience.getIndividual().getBirthDate())) {
				errors.rejectValue("startDate", "Start date must be at least starting from 8 years");
			}

			if (endDate != null) {
				if (endDate.after(new Date())) {
					errors.rejectValue("endDate", "Invalid end date");
				} else if (startDate != null && endDate.before(startDate)) {
					errors.rejectValue("endDate", "End date cannot be before startDate");
				}
			}

			if (jobTitle == null) {
				errors.rejectValue("jobTitle", "Please select type");
			}
		}
	}

}
