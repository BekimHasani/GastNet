package org.gastnet.businessmicro.validator;

import org.apache.commons.lang3.StringUtils;
import org.gastnet.businessmicro.entity.BusinessImage;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BusinessImageValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(BusinessImage.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        BusinessImage businessImage = (BusinessImage) target;

        String image = businessImage.getImage();
        if (StringUtils.isBlank(image)) {
            errors.rejectValue("image","Image cannot be empty");
        }
    }
}
