package org.gastnet.businessmicro.service;

import java.util.List;
import java.util.Set;

import org.gastnet.businessmicro.entity.Business;
import org.gastnet.businessmicro.entity.Contact;

public interface ContactService {

	Contact save(Contact contact);
	
	Contact findById(long contactId);
	
	List<Contact> findAll();

	Set<Contact> findByBusiness(Business business);
}
