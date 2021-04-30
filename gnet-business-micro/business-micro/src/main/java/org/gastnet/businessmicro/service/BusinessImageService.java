package org.gastnet.businessmicro.service;

import java.util.List;

import org.gastnet.businessmicro.entity.BusinessImage;
import org.gastnet.businessmicro.entity.Location;

public interface BusinessImageService {

	BusinessImage save(BusinessImage businessImage);
	
	BusinessImage findById(long businessImageId);
	
	List<BusinessImage> findAll();

	List<BusinessImage> findByLocation(Location location);
}
