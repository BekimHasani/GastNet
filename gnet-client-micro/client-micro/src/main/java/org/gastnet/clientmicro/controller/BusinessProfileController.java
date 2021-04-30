package org.gastnet.clientmicro.controller;

import javax.servlet.http.HttpServletRequest;

import org.gastnet.clientmicro.dto.BusinessProfileDTO;
import org.gastnet.clientmicro.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/business")
public class BusinessProfileController {
	
	@Autowired
	private BusinessService businessService;

	@GetMapping("/profile")
	public String getBusinessProfile(Model model,HttpServletRequest request) {
		BusinessProfileDTO dto = businessService.getBusinessProfileData(2L,request);
		model.addAttribute("business",dto.getBusiness());
		model.addAttribute("contacts",dto.getContacts());
		model.addAttribute("locations",dto.getLocations());
		model.addAttribute("expertises",dto.getExpertises());
		return "business-profile";
	}
}
