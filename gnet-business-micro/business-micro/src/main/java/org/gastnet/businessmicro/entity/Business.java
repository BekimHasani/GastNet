package org.gastnet.businessmicro.entity;

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

import org.gastnet.businessmicro.enumeration.Category;
import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Business {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long businessId;
	
	@Column(nullable = false, unique = true, length = 40)
	private String name;
	
	@Column(nullable = false, unique = true, length = 40)
	@Length(message = "Business number maximum length is 40")
	private String businessNumber;
	
	@Column(nullable = true)
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private Category category;
	
	@Column(nullable = false)
	private Long userId;
	
	@JsonIgnore
	@OneToMany(mappedBy = "business")
	private Set<Contact> contacts = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "business")
	private Set<Location> locations = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "business")
	private Set<BusinessExpertise> businessExpertise = new HashSet<>();
}
