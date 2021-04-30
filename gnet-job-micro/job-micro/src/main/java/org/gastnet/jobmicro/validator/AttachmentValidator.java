package org.gastnet.jobmicro.validator;

import org.apache.commons.lang.StringUtils;
import org.gastnet.jobmicro.entity.Attachment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AttachmentValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Attachment.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Attachment attachment = (Attachment) target;

        String attachedFile = attachment.getAttachedFile();
        if (StringUtils.isBlank(attachedFile)) {
            errors.rejectValue("attachedFile", "Attached file status cannot be empty");
        }
    }
}
