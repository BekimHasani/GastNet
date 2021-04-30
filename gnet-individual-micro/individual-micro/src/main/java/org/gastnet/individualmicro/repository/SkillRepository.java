package org.gastnet.individualmicro.repository;

import java.util.List;

import org.gastnet.individualmicro.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
	
	
}
