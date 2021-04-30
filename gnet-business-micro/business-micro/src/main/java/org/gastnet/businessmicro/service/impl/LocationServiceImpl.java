package org.gastnet.businessmicro.service.impl;

import java.util.List;
import java.util.Set;

import org.gastnet.businessmicro.entity.Business;
import org.gastnet.businessmicro.entity.Location;
import org.gastnet.businessmicro.repository.LocationRepository;
import org.gastnet.businessmicro.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public Location save(Location location) {
		return locationRepository.save(location);
	}

	@Override
	public Location findById(long locationId) {
		return locationRepository.findById(locationId).orElse(null);
	}

	@Override
	public List<Location> findAll() {
		return locationRepository.findAll();
	}

	@Override
	public Set<Location> findByBusiness(Business business) {
		return locationRepository.findByBusiness(business);
	}

}
