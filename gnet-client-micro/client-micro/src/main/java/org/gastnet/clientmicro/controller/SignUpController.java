package org.gastnet.clientmicro.controller;

import org.gastnet.clientmicro.dto.BusinessUserDTO;
import org.gastnet.clientmicro.dto.IndividualUserDTO;
import org.gastnet.clientmicro.enumeration.Category;
import org.gastnet.clientmicro.enumeration.ContactType;
import org.gastnet.clientmicro.enumeration.IndividualType;
import org.gastnet.clientmicro.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
	
	@Autowired
	public SignUpService signUpService;
	
	@GetMapping("/signup-individual")
	public String individualSignUp(Model model) {
		model.addAttribute("individualUser", new IndividualUserDTO());
		model.addAttribute("individualTypes",IndividualType.values());
		return "register-individual";
	}
	
	@PostMapping("/process-signup-individual") 
	public String processIndividualSingUp(@ModelAttribute IndividualUserDTO individualUserDTO,BindingResult bindingResult,
								Model model ){
		signUpService.individualSignUp(individualUserDTO, bindingResult);
		if(bindingResult.hasErrors()) {
			model.addAttribute("individualUser",individualUserDTO);
			model.addAttribute("individualTypes",IndividualType.values());
			return "register-individual";
		}
		return "successful-register";
	}
	
	@GetMapping("/signup-business")
	public String businessSignUp(Model model) {
		model.addAttribute("businessUser",new BusinessUserDTO());
		model.addAttribute("categories",Category.values());
		return "register-business";
	}
	
	@PostMapping("/process-signup-business")
	public String processBusinessSignUp(@ModelAttribute BusinessUserDTO businessUserDTO,BindingResult bindingResult,
								Model model) {
		signUpService.businessSignUp(businessUserDTO,bindingResult);
		if(bindingResult.hasErrors()) {
			bindingResult.rejectValue("user.password", "user.password","user.password");
			model.addAttribute("businessUser",businessUserDTO);
			model.addAttribute("categories",Category.values());
			return "register-business";
		}
		return "successful-register";
	}
	 
}
