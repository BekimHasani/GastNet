package org.gastnet.businessmicro.validator;

import org.apache.commons.lang3.StringUtils;
import org.gastnet.businessmicro.entity.Location;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class LocationValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Location.class); }

    @Override
    public void validate(Object target, Errors errors) {
        Location location = (Location) target;

        String state = location.getState();
        if (StringUtils.isBlank(state)) {
            errors.rejectValue("state","State cannot be empty");
        }

        String city = location.getCity();
        if (StringUtils.isBlank(city)) {
            errors.rejectValue("city", "City cannot be empty");
        }

        String address = location.getAddress();
        if (StringUtils.isBlank(address)) {
            errors.rejectValue("address", "Address cannot be empty");
        }
    }
}
