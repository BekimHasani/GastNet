package org.gastnet.clientmicro.model;

import java.util.Date;

import org.gastnet.clientmicro.enumeration.ActivityType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalData {

	private Long professionalDataId;

	private String title;

	@DateTimeFormat(iso = ISO.DATE)
	private Date startDate;
	
	@DateTimeFormat(iso = ISO.DATE)
	private Date endDate;
	
	private String description;
	
	private String attachment; 

	private ActivityType activityType;
	
	private Individual individual;
	
	
}
