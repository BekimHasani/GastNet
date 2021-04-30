package org.gastnet.individualmicro.service;

import java.util.List;
import java.util.Set;

import org.gastnet.individualmicro.entity.Individual;
import org.gastnet.individualmicro.entity.IndividualSkill;

public interface IndividualSkillService  {


	List<IndividualSkill> findAll();
	IndividualSkill save(IndividualSkill individualSkill);
	IndividualSkill findById(Long id);
	void delete(IndividualSkill individualSkill);
	Set<IndividualSkill>findByIndividual(Individual individual);
}
