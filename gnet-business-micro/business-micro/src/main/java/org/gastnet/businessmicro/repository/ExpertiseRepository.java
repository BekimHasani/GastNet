package org.gastnet.businessmicro.repository;

import org.gastnet.businessmicro.entity.Expertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertiseRepository extends JpaRepository<Expertise, Long>{
}
