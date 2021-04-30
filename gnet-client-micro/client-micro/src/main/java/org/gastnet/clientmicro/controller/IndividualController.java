package org.gastnet.clientmicro.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.gastnet.clientmicro.enumeration.ActivityType;
import org.gastnet.clientmicro.enumeration.JobTitle;
import org.gastnet.clientmicro.model.Experience;
import org.gastnet.clientmicro.model.Individual;
import org.gastnet.clientmicro.model.IndividualSkill;
import org.gastnet.clientmicro.model.ProfessionalData;
import org.gastnet.clientmicro.service.IndividualService;
import org.gastnet.clientmicro.session.IndividualCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndividualController {

	@Autowired
	private IndividualService individualService;

	@RequestMapping("/individualProfile")
	public String getIndividual(Model model, HttpServletRequest request) {
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


	@RequestMapping("/individualHomePage")
	public String getIndividualHomePage() {
		return "individualHomePage";
	}

	@RequestMapping("/individualApplications")
	public String getIndividualApplications() {
		return "individualApplications";
	}
	

	@PostMapping("/new-experience")
	public String addNewIndividualExperience(@ModelAttribute("newIndividualExperience") Experience experience,
			Model model, BindingResult bindingResult, HttpServletRequest request ) {
		IndividualCredentials individualCredentials = (IndividualCredentials) request.getSession()
				.getAttribute("individualCredentials");
		Individual individual = individualService.getIndividual(request, individualCredentials.getIndividualId());
		experience.setIndividual(individual);
		if(experience != null) {
			individualService.addNewExperience(request, experience);
		}
		return "redirect:/individualProfile";
	}
	
	
	@PostMapping("/new-skill")
	public String addNewIndividualSkill(@ModelAttribute("newIndividualSkill") IndividualSkill skill,
			Model model, BindingResult bindingResult, HttpServletRequest request ) {
		IndividualCredentials individualCredentials = (IndividualCredentials) request.getSession()
				.getAttribute("individualCredentials");
		Individual individual = individualService.getIndividual(request, individualCredentials.getIndividualId());
		skill.setIndividual(individual);
		if(skill != null) {
			individualService.addNewSkill(request, skill);
		}
		return "redirect:/individualProfile";
	}
	
	@PostMapping("/new-professionalData")
	public String addNewIndividualProfessionalData(@ModelAttribute("newIndividualProfessionalData") ProfessionalData data,
			Model model, BindingResult bindingResult, HttpServletRequest request ) {
		IndividualCredentials individualCredentials = (IndividualCredentials) request.getSession()
				.getAttribute("individualCredentials");
		Individual individual = individualService.getIndividual(request, individualCredentials.getIndividualId());
		data.setIndividual(individual);
		if(data != null) {
			individualService.addNewProfessionalData(request, data);
		}
		return "redirect:/individualProfile";
	}
	
	@PostMapping("/delete-experience")
	public String deleteIndividualExperience(@ModelAttribute("newIndividualExperience") Experience experience,
			Model model, BindingResult bindingResult, HttpServletRequest request ) {
		if(experience.getExperienceId() != null) {
			individualService.deleteExperience(request, experience.getExperienceId());
		}
		return "redirect:/individualProfile";
	}
	
	
	@PostMapping("/delete-skill")
	public String deleteIndividualSkill(@ModelAttribute("newIndividualSkill") IndividualSkill skill,
			Model model, BindingResult bindingResult, HttpServletRequest request ) {
		if(skill.getId() != null) {
			individualService.deleteSkill(request, skill.getId());
		}
		return "redirect:/individualProfile";
	}
	
	@PostMapping("/delete-data")
	public String deleteIndividualData(@ModelAttribute("newIndividualProfessionalData") ProfessionalData data,
			Model model, BindingResult bindingResult, HttpServletRequest request ) {
		if(data.getProfessionalDataId() != null) {
			individualService.deleteProfessionalData(request, data.getProfessionalDataId());
		}
		return "redirect:/individualProfile";
	}

}
