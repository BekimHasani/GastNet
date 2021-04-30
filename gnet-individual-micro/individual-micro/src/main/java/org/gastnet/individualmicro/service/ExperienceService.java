package org.gastnet.individualmicro.service;

import java.util.List;
import java.util.Set;

import org.gastnet.individualmicro.entity.Experience;
import org.gastnet.individualmicro.entity.Individual;



public interface ExperienceService {

		List<Experience> findAll();
		Experience save(Experience experience);
		Experience findById(Long experienceId);
		void delete(Experience experience);
		Set<Experience> findByIndividual(Individual individual);

}
