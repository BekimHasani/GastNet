package org.gastnet.individualmicro.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.gastnet.individualmicro.entity.Individual;
import org.gastnet.individualmicro.repository.IndividualRepository;
import org.gastnet.individualmicro.service.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class IndividualServiceImpl implements IndividualService{

	@Autowired
	private IndividualRepository individualRepo;
	
	@Override
	public List<Individual> findAll() {
		return individualRepo.findAll();
	}

	@Override
	public Individual save(Individual individual) {
		return individualRepo.save(individual);
	}

	@Override
	public Individual findById(Long individualId) {
		return individualRepo.findById(individualId).orElse(null);
	}

	@Override
	public void delete(Individual individual) {
		individualRepo.delete(individual);
	}

	@Override
	public Individual findByUserId(Long userId) {
		return individualRepo.findByUserId(userId);
	}

}
