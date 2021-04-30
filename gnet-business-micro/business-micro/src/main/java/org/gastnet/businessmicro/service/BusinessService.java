package org.gastnet.businessmicro.service;

import java.util.List;

import org.gastnet.businessmicro.entity.Business;

public interface BusinessService {

	Business save(Business business);
	
	Business findById(long businessId);
	
	List<Business> findAll();
	
	Business getProfileData(long userId);
	
}
