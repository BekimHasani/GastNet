package org.gastnet.jobmicro.validator;

import org.gastnet.jobmicro.entity.JobOpening;
import org.gastnet.jobmicro.enumeration.JobOpeningStatus;
import org.gastnet.jobmicro.enumeration.JobShiftType;
import org.gastnet.jobmicro.enumeration.JobTitle;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

@Component
public class JobOpeningValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(JobOpening.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        JobOpening jobOpening = (JobOpening) target;

        JobTitle title = jobOpening.getJobTitle();
        if (title == null) {
            errors.rejectValue("jobTitle","Jop title cannot be empty");
        }

        Date expiryDate = jobOpening.getExpiryDate();
        if (expiryDate == null) {
            errors.rejectValue("expiryDate","Expiry date cannot be empty");
        }

        JobOpeningStatus status = jobOpening.getStatus();
        if (status == null) {
            errors.rejectValue("status","Job opening status cannot be empty");
        }

        JobShiftType jobShiftType = jobOpening.getJobShiftType();
        if (jobShiftType == null) {
            errors.rejectValue("jobShiftType","Job shift type cannot be empty");
        }

        Long businessId = jobOpening.getBusinessId();
        if (businessId == null) {
            errors.rejectValue("businessId","Business id cannot be empty");
        }

    }
}
