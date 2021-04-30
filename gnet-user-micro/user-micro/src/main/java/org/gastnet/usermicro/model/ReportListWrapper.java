package org.gastnet.usermicro.model;

import java.util.List;

import org.gastnet.usermicro.entity.Report;

public class ReportListWrapper {

	private List<Report> reports; 
	
	public ReportListWrapper(List<Report> reports) {
		this.reports = reports;
	}
	
	public List<Report> getReports(){
		return reports;
	}
	
}
