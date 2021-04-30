package org.gastnet.businessmicro.service.impl;

import java.util.List;

import org.gastnet.businessmicro.entity.BusinessExpertise;
import org.gastnet.businessmicro.repository.BusinessExpertiseRepository;
import org.gastnet.businessmicro.service.BusinessExpertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessExpertiseServiceImpl implements BusinessExpertiseService {

	@Autowired
	private BusinessExpertiseRepository businessExpertiseRepository;
	@Override
	public BusinessExpertise save(BusinessExpertise businessExpertise) {
		return businessExpertiseRepository.save(businessExpertise);
	}

	@Override
	public BusinessExpertise findById(long businessExpertiseId) {
		return businessExpertiseRepository.findById(businessExpertiseId).orElse(null);
	}

	@Override
	public List<BusinessExpertise> findAll() {
		return businessExpertiseRepository.findAll();
	}

}
