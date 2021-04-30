package org.gastnet.reviewmicro.utils;

import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

public class ValidationUtils {
    private ValidationUtils() {}

    public static Map<String,String> getFieldErrors(BindingResult bindingResult){
        Map<String,String> errors = new HashMap<>();
        bindingResult.getFieldErrors().forEach(error -> {
            errors.put(error.getField(),error.getCode());
        });
        return errors;
    }
}
