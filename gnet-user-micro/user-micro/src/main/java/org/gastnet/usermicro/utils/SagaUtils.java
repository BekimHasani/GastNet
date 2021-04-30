package org.gastnet.usermicro.utils;

import java.util.Set;
import java.util.stream.Collectors;

import org.gnet.common.enumeration.Category;
import org.gnet.common.enumeration.ContactType;
import org.gnet.common.enumeration.IndividualType;
import org.gnet.common.model.Business;
import org.gnet.common.model.Contact;
import org.gnet.common.model.Individual;
import org.gnet.common.model.Location;

public class SagaUtils {
	private SagaUtils() {
	}

	public static Individual convertIndividualForSaga(org.gastnet.usermicro.model.Individual individual) {
		return Individual.builder()
					.name(individual.getName())
					.lastName(individual.getLastName())
					.birthDate(individual.getBirthDate())
					.state(individual.getState())
					.city(individual.getCity())
					.gender(individual.getGender())
					.phoneNumber(individual.getPhoneNumber())
					.individualType(IndividualType.valueOf(individual.getIndividualType().toString()))
					.userId(individual.getUserId()).build();
	}
	
	public static Business convertBusinessForSaga(org.gastnet.usermicro.model.Business business) {
		return Business.builder()
					.name(business.getName())
					.businessNumber(business.getBusinessNumber())
					.category(Category.valueOf(business.getCategory().toString()))
					.contacts(convertContacts(business.getContacts()))
					.locations(convertLocations(business.getLocations()))
					.build();
	}
	
	private static Set<Contact> convertContacts(Set<org.gastnet.usermicro.model.Contact> contacts ){
		return contacts.stream().map(contact ->{
			return Contact.builder()
						  .contactValue(contact.getContactValue())
						  .contactType(ContactType.valueOf(contact.getContactType().toString()))
						  .build();
		}).collect(Collectors.toSet());
	}
	
	private static Set<Location> convertLocations(Set<org.gastnet.usermicro.model.Location> locations){
		return locations.stream().map(location ->{
			return Location.builder()
						   .state(location.getState())
						   .city(location.getCity())
						   .address(location.getAddress())
						   .description(location.getDescription())
						   .build();
		}).collect(Collectors.toSet());
	}
}
