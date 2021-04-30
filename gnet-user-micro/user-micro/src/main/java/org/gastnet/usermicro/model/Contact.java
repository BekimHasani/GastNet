package org.gastnet.usermicro.model;

import org.gastnet.usermicro.enumeration.ContactType;

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
