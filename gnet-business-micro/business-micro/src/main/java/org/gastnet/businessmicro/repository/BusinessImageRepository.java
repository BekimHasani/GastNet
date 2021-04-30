package org.gastnet.businessmicro.repository;

import org.gastnet.businessmicro.entity.BusinessImage;
import org.gastnet.businessmicro.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessImageRepository extends JpaRepository<BusinessImage, Long>{

    List<BusinessImage> findByLocation(Location location);
}
