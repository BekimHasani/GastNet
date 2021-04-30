package org.gastnet.usermicro.controller;

import org.gastnet.usermicro.enumeration.ReportStatus;
import org.gastnet.usermicro.enumeration.Role;
import org.gastnet.usermicro.model.ReportListWrapper;
import org.gastnet.usermicro.model.UserListWrapper;
import org.gastnet.usermicro.service.impl.ReportService;
import org.gastnet.usermicro.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ReportService reportService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/undoneReports")
	public ResponseEntity<ReportListWrapper> getUndoneReports(@RequestBody ReportStatus reportStatus){
		ReportListWrapper reports = new ReportListWrapper(reportService.findByReportStatus(reportStatus));	
		return new ResponseEntity<>(reports,HttpStatus.OK);
	}
	
	@PostMapping("/all")
	public ResponseEntity<UserListWrapper> getAllUsers(@RequestBody Role role){
		UserListWrapper users = new UserListWrapper(userService.findByRole(role));
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
}
