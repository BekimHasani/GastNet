package org.gastnet.reviewmicro.validator;

import org.gastnet.reviewmicro.entity.IndividualReview;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class IndividualReviewValidator implements Validator {

	@Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(IndividualReview.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        IndividualReview target = (IndividualReview) o;

        Integer rating = target.getRating();
        if (rating == null) {
            errors.rejectValue("rating", "Rating is required");
        } else if (rating < 1 || rating > 5) {
            errors.rejectValue("rating", "Rating should be between 1 and 5");
        }

        Long fromIndividualId = target.getFromIndividualId();
        if (fromIndividualId == null) {
            errors.rejectValue("fromIndividualId", "fromIndividual id is required");
        }

        Long toIndividualId = target.getToIndividualId();
        if (toIndividualId == null) {
            errors.rejectValue("toIndividualId", "toIndividual id is required");
        }
    }

}
