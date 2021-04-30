package org.gastnet.individualmicro.validator;

import org.gastnet.individualmicro.entity.Individual;
import org.gastnet.individualmicro.entity.IndividualSkill;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class IndividualSkillValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(IndividualSkill.class) || clazz.equals(Individual.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (target instanceof IndividualSkill) {
			IndividualSkill individaulSkill = (IndividualSkill) target;
			String skill = individaulSkill.getSkill();

			if (skill == null) {
				errors.rejectValue("skill", "Please add skill");
			}
		}
	}
}
