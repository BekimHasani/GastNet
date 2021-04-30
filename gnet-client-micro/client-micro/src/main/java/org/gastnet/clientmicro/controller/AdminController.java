package org.gastnet.clientmicro.controller;

import javax.servlet.http.HttpServletRequest;

import org.gastnet.clientmicro.enumeration.ReportStatus;
import org.gastnet.clientmicro.enumeration.Role;
import org.gastnet.clientmicro.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController{
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/adminDashboard")
	public String admiDashboard(Model model, HttpServletRequest request) {
		model.addAttribute("adminUsers",adminService.getAllAdmins(request, Role.ADMIN));
		model.addAttribute("pendingReports", adminService.getReports(request, ReportStatus.UNDONE).size());
		model.addAttribute("checkedReports", adminService.getReports(request, ReportStatus.DONE).size());
		model.addAttribute("individuals", adminService.getAllIdividuals(request).size());
		model.addAttribute("businesses", adminService.getAllBusinesses(request).size());
		return "adminDashboard";
	}
	
	@GetMapping("/reports")
	public String reports(Model model, HttpServletRequest request) {
		model.addAttribute("reports",adminService.getReports(request, ReportStatus.UNDONE));
		return "reports";
	}

	
}