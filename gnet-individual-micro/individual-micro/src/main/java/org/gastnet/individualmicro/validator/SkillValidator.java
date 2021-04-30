package org.gastnet.individualmicro.validator;

import org.gastnet.individualmicro.entity.Skill;
import org.gastnet.individualmicro.utils.ValidationUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SkillValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Skill.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Skill skill = (Skill)target;
		
		if(ValidationUtils.isTrimedEmpty(skill.getSkill())) {
			errors.rejectValue("skill", "Skill cannot be empty");
		}
		
	}

}
