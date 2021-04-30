package org.gastnet.businessmicro.service;

import java.util.List;
import java.util.Set;

import org.gastnet.businessmicro.entity.Business;
import org.gastnet.businessmicro.entity.Location;

public interface LocationService {

	Location save(Location location);
	
	Location findById(long locationId);
	
	List<Location> findAll();

	Set<Location> findByBusiness(Business business);
}
