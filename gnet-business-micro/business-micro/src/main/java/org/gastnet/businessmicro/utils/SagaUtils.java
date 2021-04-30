package org.gastnet.businessmicro.utils;

import java.util.Set;
import java.util.stream.Collectors;

import org.gastnet.businessmicro.entity.Business;
import org.gastnet.businessmicro.entity.Contact;
import org.gastnet.businessmicro.entity.Location;
import org.gastnet.businessmicro.enumeration.Category;
import org.gastnet.businessmicro.enumeration.ContactType;

public class SagaUtils {
	private SagaUtils() {
	}

	public static Business convertToBusinessEntity(org.gnet.common.model.Business business) {
		Business entity = new Business();
		entity.setName(business.getName());
		entity.setBusinessNumber(business.getBusinessNumber());
		entity.setDescription(business.getDescription());
		entity.setCategory(Category.valueOf(business.getCategory().toString()));
		entity.setContacts(convertContacts(business.getContact()));
		entity.setLocations(convertLocations(business.getLocation()));
		return entity;
	}
	
	public static Set<Contact> convertContacts(Set<org.gnet.common.model.Contact> contacts) {
		Set<Contact> entities = contacts.stream().map(contact ->{
			Contact entity = new Contact();
			entity.setContactType(ContactType.valueOf(contact.getContactType().toString()));
			entity.setContactValue(contact.getContactValue());
			return entity;
		}).collect(Collectors.toSet());
		return entities;
	}
	
	public static Set<Location> convertLocations(Set<org.gnet.common.model.Location> locations ){
		Set<Location> entities = locations.stream().map(location ->{
			Location entity = new Location();
			entity.setCity(location.getCity());
			entity.setState(location.getState());
			entity.setAddress(location.getAddress());
			entity.setDescription(location.getDescription());
			return entity;
		}).collect(Collectors.toSet());
		return entities;
	}
	
}
