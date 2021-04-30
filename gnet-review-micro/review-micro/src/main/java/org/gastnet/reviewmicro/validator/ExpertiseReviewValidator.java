package org.gastnet.reviewmicro.validator;

import org.gastnet.reviewmicro.entity.ExpertiseReview;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ExpertiseReviewValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(ExpertiseReview.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ExpertiseReview target = (ExpertiseReview) o;

        Integer rating = target.getRating();
        if (rating == null) {
            errors.rejectValue("rating", "Rating is required");
        } else if (rating < 1 || rating > 5) {
            errors.rejectValue("rating", "Rating should be between 1 and 5");
        }

        Long individualId = target.getIndividualId();
        if (individualId == null) {
            errors.rejectValue("individualId", "Individual id is required");
        }

        Long businessId = target.getBusinessId();
        if (businessId == null) {
            errors.rejectValue("businessId", "Business id is required");
        }
    }
}
