package org.gastnet.individualmicro.repository;

import java.util.Set;

import org.gastnet.individualmicro.entity.Individual;
import org.gastnet.individualmicro.entity.ProfessionalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalDataRepository extends JpaRepository<ProfessionalData, Long> {
	
	Set<ProfessionalData> findByIndividual(Individual individual);
	
}
