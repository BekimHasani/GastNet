package org.gastnet.individualmicro.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.gastnet.individualmicro.enumeration.IndividualType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Aggregate
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Individual {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@EqualsAndHashCode.Include
	@AggregateIdentifier
	private Long individualId;
	
	@Column(nullable = false, length = 40)
	private String name;
	
	@Column(nullable = false, length = 40)
	private String lastName;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date birthDate;
	
	@Column(nullable = false)
	private char gender;	
	
	@Column(length = 40)
	private String state;
	
	@Column(length = 40)
	private String city;
	
	@Column(length = 30)
	private String phoneNumber;
	
	@Column(nullable = true)
	private String imageUrl;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 15)
	private IndividualType individualType;
	
	@Column(nullable = false)
	private Long userId;
	
	@JsonIgnore
	@OneToMany(mappedBy = "individual")
	private Set<Experience>	experiences = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "individual")
	private Set<IndividualSkill> individualSkills = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "individual")
	private Set<ProfessionalData> professionalData = new HashSet<>();
	
}
