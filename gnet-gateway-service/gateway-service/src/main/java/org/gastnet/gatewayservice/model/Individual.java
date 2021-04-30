package org.gastnet.gatewayservice.model;

import java.util.Date;

import org.gastnet.gatewayservice.enumeration.IndividualType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Individual {
	
	private String individualId;
	
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
