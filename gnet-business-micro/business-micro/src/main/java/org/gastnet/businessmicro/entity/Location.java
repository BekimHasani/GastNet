package org.gastnet.businessmicro.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long locationId;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = true)
	private String description;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "business_id")
	private Business business;
	
	@JsonIgnore
	@OneToMany(mappedBy = "location")
	private Set<BusinessImage> businessImage = new HashSet<>();
	
}
