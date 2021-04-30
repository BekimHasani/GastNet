package org.gastnet.individualmicro.service.impl;

import java.util.List;
import java.util.Set;

import org.gastnet.individualmicro.entity.Experience;
import org.gastnet.individualmicro.entity.Individual;
import org.gastnet.individualmicro.repository.ExperienceRepository;
import org.gastnet.individualmicro.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceServiceImpl implements ExperienceService {

	@Autowired
	private ExperienceRepository experienceRepo;
	
	@Override
	public List<Experience> findAll() {
		return experienceRepo.findAll();
	}

	@Override
	public Experience save(Experience experience) {
		return experienceRepo.save(experience);
	}

	@Override
	public Experience findById(Long experienceId) {
		return experienceRepo.findById(experienceId).orElse(null);	
	}

	@Override
	public void delete(Experience experience) {
		 experienceRepo.delete(experience);
	}

	@Override
	public Set<Experience> findByIndividual(Individual individual) {
		return experienceRepo.findByIndividual(individual);
	}
	
}
