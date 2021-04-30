package org.gastnet.businessmicro.service.impl;

import java.util.List;

import org.gastnet.businessmicro.entity.BusinessImage;
import org.gastnet.businessmicro.entity.Location;
import org.gastnet.businessmicro.repository.BusinessImageRepository;
import org.gastnet.businessmicro.service.BusinessImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessImageServiceImpl implements BusinessImageService {

	@Autowired
	private BusinessImageRepository businessImageRepository;

	@Override
	public BusinessImage save(BusinessImage businessImage) {
		return businessImageRepository.save(businessImage);
	}

	@Override
	public BusinessImage findById(long businessImageId) {
		return businessImageRepository.findById(businessImageId).orElse(null) ;
	}

	@Override
	public List<BusinessImage> findAll() {
		return businessImageRepository.findAll();
	}

	@Override
	public List<BusinessImage> findByLocation(Location location) {
		return businessImageRepository.findByLocation(location);
	}
}
