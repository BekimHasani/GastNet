package org.gastnet.clientmicro.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.gastnet.clientmicro.enumeration.IndividualType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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

	@DateTimeFormat(iso = ISO.DATE)
	private Date birthDate;
	
	private String state;
	
	private String city;

	private char gender;

	private String phoneNumber;

	private IndividualType individualType;

	private Long userId;

	private Set<Experience>	experiences = new HashSet<>();

	private Set<IndividualSkill> individualSkills = new HashSet<>();

	private Set<ProfessionalData> professionalData = new HashSet<>();

}
