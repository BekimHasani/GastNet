package org.gastnet.reviewmicro.validator;

import org.gastnet.reviewmicro.entity.SkillReview;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SkillReviewValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(SkillReview.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SkillReview target = (SkillReview) o;

        Integer rating = target.getRating();
        if (rating == null) {
            errors.rejectValue("rating", "Rating is required");
        } else if (rating < 1 || rating > 5) {
            errors.rejectValue("rating", "Rating should be between 1 and 5");
        }

        Long individualSkillId = target.getIndividualSkillId();
        if (individualSkillId == null) {
            errors.rejectValue("individualSkillId", "Individual skill id is required");
        }

        Long individualId = target.getIndividualId();
        if (individualId == null) {
            errors.rejectValue("individualId", "Individual id is required");
        }
    }
}
