package org.gastnet.businessmicro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessExpertise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long businessExpertiseId;
	
	@Column(nullable = true)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "business_id")
	private Business business;
	
	private String expertise;

	public BusinessExpertise(Business business, String expertise) {
		this.business = business;
		this.expertise = expertise;
	}
}
