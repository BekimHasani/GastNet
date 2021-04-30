package org.gastnet.businessmicro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expertise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long expertiseId;
	
	@Column(nullable = false , length = 30)
	private String expertise;
	
	private String description;
	
	private long individualId;
}
