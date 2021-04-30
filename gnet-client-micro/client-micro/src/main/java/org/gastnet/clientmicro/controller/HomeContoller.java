package org.gastnet.clientmicro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeContoller {
	
	@RequestMapping("/home")
	public String homePage() {
		return "homePage";
	}
	
	@RequestMapping("/contactUs")
	public String contactUs() {
		return "contact";
	}

}
