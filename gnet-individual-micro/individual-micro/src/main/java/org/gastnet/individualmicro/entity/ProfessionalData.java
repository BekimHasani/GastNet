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

import org.gastnet.individualmicro.enumeration.ActivityType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long professionalDataId;
	
	@Column(nullable = false, length = 125)
	private String title;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = true)
	private Date endDate;
	
	@Column(nullable = true)
	private String description;
	
	@Column(nullable = true)
	private String attachment; 
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ActivityType activityType;
	
	@ManyToOne
	@JoinColumn(name = "individual_id")
	private Individual individual;
	
	
}
