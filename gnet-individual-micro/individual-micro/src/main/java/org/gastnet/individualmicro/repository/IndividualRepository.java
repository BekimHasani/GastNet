package org.gastnet.individualmicro.repository;

import org.gastnet.individualmicro.entity.Individual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualRepository extends JpaRepository<Individual, Long> {

	Individual findByUserId(Long userId);
	
}
