package org.gastnet.businessmicro.validator;

import org.apache.commons.lang3.StringUtils;
import org.gastnet.businessmicro.entity.Expertise;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ExpertiseValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Expertise.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Expertise expertise = (Expertise) target;

        String expertiseValue = expertise.getExpertise();
        if (StringUtils.isBlank(expertiseValue)) {
            errors.rejectValue("expertise","Expertise value cannot be empty");
        } else if (expertiseValue.length() > 30) {
            errors.reject("expertise","Expertise value must contain less than 30 characters");
        }
    }
}
