package org.gastnet.individualmicro.service;

import java.util.List;

import org.gastnet.individualmicro.entity.Individual;

public interface IndividualService {

	List<Individual> findAll();
	Individual save(Individual individual);
	Individual findById(Long individualId);
	void delete(Individual individual);
	Individual findByUserId(Long userId);
}
