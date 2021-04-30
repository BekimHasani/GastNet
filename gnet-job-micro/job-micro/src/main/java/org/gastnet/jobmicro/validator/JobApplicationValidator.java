package org.gastnet.jobmicro.validator;

import org.gastnet.jobmicro.entity.JobApplication;
import org.gastnet.jobmicro.entity.JobOpening;
import org.gastnet.jobmicro.enumeration.JobApplicationStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class JobApplicationValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(JobApplication.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        JobApplication application = (JobApplication) target;

        Long individualId = application.getIndividualId();
        if (individualId == null) {
            errors.rejectValue("individualId","Individual cannot be empty");
        }

        JobApplicationStatus status = application.getStatus();
        if (status == null) {
            errors.rejectValue("status", "Job application status cannot be empty");
        }

        JobOpening opening = application.getJobOpening();
        if (opening == null) {
            errors.rejectValue("jobOpening", "Job opening cannot be empty");
        }
    }
}
