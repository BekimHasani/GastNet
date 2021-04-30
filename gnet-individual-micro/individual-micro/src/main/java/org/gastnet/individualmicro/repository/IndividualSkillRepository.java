package org.gastnet.individualmicro.repository;

import java.util.Set;

import org.gastnet.individualmicro.entity.Individual;
import org.gastnet.individualmicro.entity.IndividualSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualSkillRepository extends JpaRepository<IndividualSkill, Long> {

	Set<IndividualSkill> findByIndividual(Individual individual);
}
