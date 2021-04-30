package org.gastnet.businessmicro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long businessImageId;
	
	@Column(nullable = false)
	private String image;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;
}
