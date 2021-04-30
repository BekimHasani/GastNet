package org.gastnet.individualmicro.service;

import java.util.List;

import org.gastnet.individualmicro.entity.Skill;

public interface SkillService {
	List<Skill> findAll();
	Skill save(Skill skill);
	Skill findById(Long id);
	void delete(Skill skill);
}
