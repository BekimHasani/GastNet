package org.gastnet.clientmicro.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ReportListWrapper {

	private List<Report> reports; 
	
	public List<Report> getReports(){
		return reports;
	}
}
