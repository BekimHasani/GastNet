package org.gastnet.clientmicro.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.gastnet.clientmicro.enumeration.ReportStatus;
import org.gastnet.clientmicro.enumeration.Role;
import org.gastnet.clientmicro.model.Business;
import org.gastnet.clientmicro.model.Individual;
import org.gastnet.clientmicro.model.Report;
import org.gastnet.clientmicro.model.User;

public interface AdminService {
	
	List<Report> getReports(HttpServletRequest request, ReportStatus status);
	
	List<User> getAllAdmins(HttpServletRequest request, Role role);

	List<Individual> getAllIdividuals(HttpServletRequest request);

	List<Business> getAllBusinesses(HttpServletRequest request);
}
