package org.gastnet.individualmicro.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.gastnet.individualmicro.entity.Experience;
import org.gastnet.individualmicro.entity.IndividualSkill;
import org.gastnet.individualmicro.entity.ProfessionalData;
import org.gastnet.individualmicro.enumeration.IndividualType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IndividualModel {

	public Long individualId;
	
	public String name;
	
	public String lastName;

	public Date birthDate;
	
	public char gender;
	
	public String city;
	
	public String state;

	public String phoneNumber;
	
	public String imageUrl;

	public IndividualType individualType;

	public Long userId;
	
	public Set<Experience>	experiences = new HashSet<>();
	
	public Set<IndividualSkill> individualSkills = new HashSet<>();

	public Set<ProfessionalData> professionalData = new HashSet<>();
}
