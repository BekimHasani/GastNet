package org.gastnet.clientmicro.model;

import org.gastnet.clientmicro.enumeration.ReportStatus;
import org.gastnet.clientmicro.enumeration.ReportType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
	

	private Long reportId;

	private String description;
	
	private Long objectId;

	private String objectType;
	
	private ReportStatus reportStatus;
	
	private ReportType reportType;
	
	private User user;
}
