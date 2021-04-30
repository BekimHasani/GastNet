package org.gastnet.clientmicro.model;

import java.util.Date;

import org.gastnet.clientmicro.enumeration.JobTitle;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Experience {

	private Long experienceId;

	@DateTimeFormat(iso = ISO.DATE)
	private Date startDate;

	@DateTimeFormat(iso = ISO.DATE)
	private Date endDate;

	private JobTitle jobTitle;

	private String description;

	private Individual individual;

	private Long business;

	
}
