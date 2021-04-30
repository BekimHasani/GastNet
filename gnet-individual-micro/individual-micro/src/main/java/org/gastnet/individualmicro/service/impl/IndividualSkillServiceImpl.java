package org.gastnet.individualmicro.service.impl;

import java.util.List;
import java.util.Set;

import org.gastnet.individualmicro.entity.Individual;
import org.gastnet.individualmicro.entity.IndividualSkill;
import org.gastnet.individualmicro.repository.IndividualSkillRepository;
import org.gastnet.individualmicro.service.IndividualSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndividualSkillServiceImpl implements IndividualSkillService {

	@Autowired
	private IndividualSkillRepository individualSkillRepo;

	@Override
	public List<IndividualSkill> findAll() {
		return individualSkillRepo.findAll();
	}

	@Override
	public IndividualSkill save(IndividualSkill individualSkill) {
		return individualSkillRepo.save(individualSkill);
	}

	@Override
	public IndividualSkill findById(Long id) {
		return individualSkillRepo.findById(id).orElse(null);
	}

	@Override
	public void delete(IndividualSkill individualSkill) {
		individualSkillRepo.delete(individualSkill);
	}

	@Override
	public Set<IndividualSkill> findByIndividual(Individual individual) {
		return individualSkillRepo.findByIndividual(individual);
	}

}
