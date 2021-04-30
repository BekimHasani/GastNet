package org.gastnet.individualmicro.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.gastnet.individualmicro.enumeration.JobTitle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Experience {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long experienceId;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	private Date endDate;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	private JobTitle jobTitle;
	
	@Column(nullable = true)
	private String description;

	@ManyToOne
	@JoinColumn(name = "individual_id")
	private Individual individual;
	
	@Column(nullable = true)
	private Long business;
	
}
