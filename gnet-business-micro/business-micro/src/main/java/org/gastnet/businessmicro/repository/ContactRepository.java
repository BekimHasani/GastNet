package org.gastnet.businessmicro.repository;

import java.util.Set;

import org.gastnet.businessmicro.entity.Business;
import org.gastnet.businessmicro.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

    Set<Contact> findByBusiness(Business business);
}
		

