package org.gastnet.businessmicro.repository;

import org.gastnet.businessmicro.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long>{
	
	Business findByUserId(long userId);
}
