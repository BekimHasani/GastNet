package org.gastnet.clientmicro.service;

import javax.servlet.http.HttpServletRequest;

import org.gastnet.clientmicro.model.Experience;
import org.gastnet.clientmicro.model.Individual;
import org.gastnet.clientmicro.model.IndividualSkill;
import org.gastnet.clientmicro.model.ProfessionalData;

public interface IndividualService {

	Individual getIndividual(HttpServletRequest request, Long individualId);

	Individual getIndividualByUserId(HttpServletRequest request, Long userId);

	void addNewExperience(HttpServletRequest request, Experience experience);

	void addNewSkill(HttpServletRequest request, IndividualSkill skill);

	void addNewProfessionalData(HttpServletRequest request, ProfessionalData data);
	
	void deleteExperience(HttpServletRequest request, Long expereinceId);
	
	void deleteSkill(HttpServletRequest request, Long skillId);
	
	void deleteProfessionalData(HttpServletRequest request, Long dataId);

	
	
}
