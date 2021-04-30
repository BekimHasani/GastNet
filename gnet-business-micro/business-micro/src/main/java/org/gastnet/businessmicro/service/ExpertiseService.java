package org.gastnet.businessmicro.service;

import java.util.List;

import org.gastnet.businessmicro.entity.Business;
import org.gastnet.businessmicro.entity.Expertise;

public interface ExpertiseService {
	
	Expertise save(Expertise expertise);
	
	Expertise findById(long expertiseId);
	
	List<Expertise> findAll();
}
