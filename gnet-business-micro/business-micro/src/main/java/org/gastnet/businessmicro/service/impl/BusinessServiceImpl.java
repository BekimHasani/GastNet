package org.gastnet.businessmicro.service.impl;

import java.util.List;

import org.gastnet.businessmicro.entity.Business;
import org.gastnet.businessmicro.repository.BusinessRepository;
import org.gastnet.businessmicro.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	private BusinessRepository businessRepository;

	@Override
	public Business save(Business business) {
		return businessRepository.save(business);
	}

	@Override
	public Business findById(long businessId) {
		return businessRepository.findById(businessId).orElse(null);
	}

	@Override
	public List<Business> findAll() {
		return businessRepository.findAll();
	}

	@Override
	public Business getProfileData(long userId) {
		return businessRepository.findByUserId(userId);
	}

}
