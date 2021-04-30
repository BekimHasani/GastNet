package org.gastnet.businessmicro.service.impl;

import java.util.List;
import java.util.Set;

import org.gastnet.businessmicro.entity.Business;
import org.gastnet.businessmicro.entity.Contact;
import org.gastnet.businessmicro.repository.ContactRepository;
import org.gastnet.businessmicro.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Contact save(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public Contact findById(long contactId) {
		return contactRepository.findById(contactId).orElse(null);
	}

	@Override
	public List<Contact> findAll() {
		return contactRepository.findAll();
	}

	@Override
	public Set<Contact> findByBusiness(Business business) {
		return contactRepository.findByBusiness(business);
	}

}
