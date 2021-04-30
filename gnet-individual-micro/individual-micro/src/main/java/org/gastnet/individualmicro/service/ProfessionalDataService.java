package org.gastnet.individualmicro.service;

import java.util.List;
import java.util.Set;

import org.gastnet.individualmicro.entity.Individual;
import org.gastnet.individualmicro.entity.ProfessionalData;

public interface ProfessionalDataService {
	List<ProfessionalData> findAll();
	ProfessionalData save(ProfessionalData professionalData);
	ProfessionalData findById(Long professionalDataId);
	void delete(ProfessionalData professionalData);
	Set<ProfessionalData> findByIndividual(Individual individual);
	
}
