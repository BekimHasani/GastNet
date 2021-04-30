package org.gastnet.usermicro.service.impl;

import java.util.List;

import org.gastnet.usermicro.entity.Report;
import org.gastnet.usermicro.enumeration.ReportStatus;

public interface ReportService {
	
	Report save(Report report);
	
	Report findById(long reportId);
	
	List<Report> findAll();
	
	List<Report> findByReportStatus(ReportStatus reportStatus);
}
