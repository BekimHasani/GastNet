package org.gastnet.clientmicro.model;

import org.gastnet.clientmicro.enumeration.ContactType;

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
