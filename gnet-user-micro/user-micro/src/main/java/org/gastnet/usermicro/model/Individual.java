package org.gastnet.usermicro.model;

import java.util.Date;

import org.gastnet.usermicro.enumeration.IndividualType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Individual {

	private Long individualId;
	
	private String name;
	
	private String lastName;
	
	private Date birthDate;
	
	private String state;
	
	private String city;
	
	private char gender;
	
	private String phoneNumber;
	
	private IndividualType individualType;
	
	private Long userId;
}
