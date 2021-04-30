package org.gastnet.clientmicro.dto;

import java.util.Set;

import org.gastnet.clientmicro.model.Business;
import org.gastnet.clientmicro.model.BusinessExpertise;
import org.gastnet.clientmicro.model.Contact;
import org.gastnet.clientmicro.model.Location;

import lombok.Data;

@Data
public class BusinessProfileDTO {
	private Business business;
	private Set<Location> locations;
	private Set<Contact> contacts;
	private Set<BusinessExpertise> expertises;
}
