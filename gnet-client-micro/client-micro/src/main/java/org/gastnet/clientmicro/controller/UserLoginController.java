package org.gastnet.clientmicro.controller;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.gastnet.clientmicro.enumeration.ActivityType;
import org.gastnet.clientmicro.enumeration.JobTitle;
import org.gastnet.clientmicro.enumeration.ReportStatus;
import org.gastnet.clientmicro.enumeration.Role;
import org.gastnet.clientmicro.model.Experience;
import org.gastnet.clientmicro.model.Individual;
import org.gastnet.clientmicro.model.IndividualSkill;
import org.gastnet.clientmicro.model.ProfessionalData;
import org.gastnet.clientmicro.model.UserCredentials;
import org.gastnet.clientmicro.service.AdminService;
import org.gastnet.clientmicro.service.AuthenticationService;
import org.gastnet.clientmicro.service.IndividualService;
import org.gastnet.clientmicro.session.IndividualCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserLoginController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private IndividualService individualService;

	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("userCredentials", new UserCredentials());
		return "loginView";
	}

	@PostMapping("/userCredentials")
	public String loginUser(@ModelAttribute("userCredentials") UserCredentials user, Model model, BindingResult bindingResult,
			HttpServletRequest request) throws UserPrincipalNotFoundException {
		try {
			authenticationService.getUserToken(user, request);
		} catch (HttpClientErrorException | NullPointerException ex) {
			log.error("Error: "+ ex.getMessage());
			ex.printStackTrace();
			bindingResult.rejectValue("email", "email", "Bad Credentials!");
			request.setAttribute("userCredentials",new UserCredentials());
			return "loginView";
		}
		IndividualCredentials credentials = (IndividualCredentials) request.getSession().getAttribute("individualCredentials");
		
		if(credentials.getRole().equals(Role.ADMIN)) {
			model.addAttribute("adminUsers",adminService.getAllAdmins(request, Role.ADMIN));
			model.addAttribute("pendingReports", adminService.getReports(request, ReportStatus.UNDONE).size());
			model.addAttribute("checkedReports", adminService.getReports(request, ReportStatus.DONE).size());
			model.addAttribute("individuals", adminService.getAllIdividuals(request).size());
			model.addAttribute("businesses", adminService.getAllBusinesses(request).size());
			return "adminDashboard";
		}
		else if(credentials.getRole().equals(Role.INDIVIDUAL)) {
			IndividualCredentials individualCredentials = (IndividualCredentials) request.getSession()
					.getAttribute("individualCredentials");
			Individual individual = individualService.getIndividual(request, individualCredentials.getIndividualId());
			model.addAttribute("newIndividualExperience", new Experience());
			model.addAttribute("newIndividualSkill", new IndividualSkill());
			model.addAttribute("newIndividualProfessionalData", new ProfessionalData());
			model.addAttribute("individualUser", individual);
			model.addAttribute("individualEmail", individualCredentials.getEmail());
			model.addAttribute("individualExperience", individual.getExperiences());
			model.addAttribute("individualSkills",individual.getIndividualSkills());
			model.addAttribute("individualProfessionalData",individual.getProfessionalData());
			model.addAttribute("jobTitles", Arrays.asList(JobTitle.values()));
			model.addAttribute("activityType", Arrays.asList(ActivityType.values()));
			return "individualProfile";
		}
		else if(credentials.getRole().equals(Role.BUSINESS)) {
			
		}
		return null;
	}
	
	

	@GetMapping("/logout")
	public String logoutUser(HttpServletRequest request) {
		authenticationService.invalidateUserToken(request);
		return "redirect:/home";
	}
}
