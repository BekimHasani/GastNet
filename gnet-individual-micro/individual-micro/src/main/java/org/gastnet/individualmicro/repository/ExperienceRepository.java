package org.gastnet.individualmicro.repository;

import java.util.Set;

import org.gastnet.individualmicro.entity.Experience;
import org.gastnet.individualmicro.entity.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
	
	Set<Experience> findByIndividual(Individual individual);
}
