package org.gastnet.businessmicro.repository;

import java.util.Set;

import org.gastnet.businessmicro.entity.Business;
import org.gastnet.businessmicro.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{

    Set<Location> findByBusiness(Business business);
}
