package org.gastnet.businessmicro.service;

import java.util.List;

import org.gastnet.businessmicro.entity.BusinessExpertise;

public interface BusinessExpertiseService {

	BusinessExpertise save(BusinessExpertise businessExpertise);
	
	BusinessExpertise findById(long businessExpertiseId);
	
	List<BusinessExpertise> findAll();
}
