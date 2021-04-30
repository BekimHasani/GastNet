package org.gastnet.businessmicro.validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.gastnet.businessmicro.entity.Business;
import org.gastnet.businessmicro.entity.Contact;
import org.gastnet.businessmicro.enumeration.ContactType;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ContactValidator implements Validator {

    private Pattern phonePattern = Pattern.compile("\\+?[0-9]{9,13}");

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Business.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contact contact = (Contact) target;

        ContactType contactType = contact.getContactType();
        if (contactType == null) {
            errors.rejectValue("contactType","Contact type cannot be empty");
        }

        String contactValue = contact.getContactValue();
        if (StringUtils.isEmpty(contactValue)) {
            errors.rejectValue("contactValue","Contact value cannot be empty");
        } else if (contactValue.length() > 40) {
            errors.reject("contactValue","Contact value must contain less than 40 characters");
        } else if (contactType == ContactType.EMAIL) {
            EmailValidator emailValidator = EmailValidator.getInstance();
            if (!emailValidator.isValid(contactValue)) {
                errors.reject("contactValue","Contact email must be a valid email");
            }
        } else if (contactType == ContactType.PHONE) {
            Matcher matcher = phonePattern.matcher(contactValue);
            if (!matcher.matches()) {
                errors.reject("contactValue","Contact phone must be a valid phone number");
            }
        }

        Business business = contact.getBusiness();
        if (business == null || business.getBusinessId() == null) {
            errors.rejectValue("business", "Business id is required");
        }
    }
}
