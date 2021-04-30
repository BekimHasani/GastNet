package org.gastnet.gatewayservice.model;

import org.gastnet.gatewayservice.enumeration.ContactType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

	private String contactValue;

	private ContactType contactType;
	
}
