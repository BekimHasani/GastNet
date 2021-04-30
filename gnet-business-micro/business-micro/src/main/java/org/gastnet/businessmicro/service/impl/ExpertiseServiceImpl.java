package org.gastnet.businessmicro.service.impl;

import java.util.List;

import org.gastnet.businessmicro.entity.Business;
import org.gastnet.businessmicro.entity.Expertise;
import org.gastnet.businessmicro.repository.ExpertiseRepository;
import org.gastnet.businessmicro.service.ExpertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpertiseServiceImpl implements ExpertiseService {

	@Autowired
	private ExpertiseRepository expertiseRepository;

	@Override
	public Expertise save(Expertise expertise) {
		return expertiseRepository.save(expertise);
	}

	@Override
	public Expertise findById(long expertiseId) {
		return expertiseRepository.findById(expertiseId).orElse(null);
	}

	@Override
	public List<Expertise> findAll() {
		return expertiseRepository.findAll();
	}
}
