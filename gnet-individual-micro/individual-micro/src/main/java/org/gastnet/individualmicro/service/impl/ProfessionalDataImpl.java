package org.gastnet.individualmicro.service.impl;

import java.util.List;
import java.util.Set;

import org.gastnet.individualmicro.entity.Individual;
import org.gastnet.individualmicro.entity.ProfessionalData;
import org.gastnet.individualmicro.repository.ProfessionalDataRepository;
import org.gastnet.individualmicro.service.ProfessionalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionalDataImpl implements ProfessionalDataService{

	@Autowired
	private ProfessionalDataRepository professionalDataRepository;
	
	@Override
	public List<ProfessionalData> findAll() {
		return professionalDataRepository.findAll();
	}

	@Override
	public ProfessionalData save(ProfessionalData professionalData) {
		return professionalDataRepository.save(professionalData);
	}

	@Override
	public ProfessionalData findById(Long professionalDataId) {
		return professionalDataRepository.findById(professionalDataId).orElse(null);
	}

	@Override
	public void delete(ProfessionalData professionalData) {
		professionalDataRepository.delete(professionalData);
	}

	@Override
	public Set<ProfessionalData> findByIndividual(Individual individual) {
		return professionalDataRepository.findByIndividual(individual);
	}

}
