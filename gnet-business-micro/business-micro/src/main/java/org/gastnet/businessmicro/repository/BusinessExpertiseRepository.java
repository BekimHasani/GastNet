package org.gastnet.businessmicro.repository;

import org.gastnet.businessmicro.entity.BusinessExpertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessExpertiseRepository extends JpaRepository<BusinessExpertise, Long>{

}
