package org.gastnet.individualmicro.service.impl;

import java.util.List;

import org.gastnet.individualmicro.entity.Skill;
import org.gastnet.individualmicro.repository.SkillRepository;
import org.gastnet.individualmicro.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService{

	@Autowired
	private SkillRepository skillRepo;

	@Override
	public List<Skill> findAll() {
		return skillRepo.findAll();
	}

	@Override
	public Skill save(Skill skill) {
		return skillRepo.save(skill);
	}

	@Override
	public Skill findById(Long id) {
		return skillRepo.findById(id).orElse(null);
	}

	@Override
	public void delete(Skill skill) {
		skillRepo.delete(skill);
	}
}
