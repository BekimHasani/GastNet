package org.gastnet.usermicro.service;

import java.util.List;

import org.gastnet.usermicro.entity.Report;
import org.gastnet.usermicro.enumeration.ReportStatus;
import org.gastnet.usermicro.repository.ReportRepository;
import org.gastnet.usermicro.service.impl.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportRepository reportRepository;
	
	@Override
	public Report save(Report report) {
		return reportRepository.save(report);
	}

	@Override
	public Report findById(long reportId) {
		return reportRepository.findById(reportId).orElse(null);
	}

	@Override
	public List<Report> findAll() {
		return reportRepository.findAll();
	}

	@Override
	public List<Report> findByReportStatus(ReportStatus reportStatus) {
		return reportRepository.findByReportStatus(reportStatus);
	}

}
