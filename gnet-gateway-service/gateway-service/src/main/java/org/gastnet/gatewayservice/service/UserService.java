package org.gastnet.gatewayservice.service;

import org.gastnet.gatewayservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("users")
public class UserService {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/user/{email}")
	public User gatUserByEmail(@PathVariable("email") String email) {
		return restTemplate.getForObject("http://user-micro/users/user/" + email, User.class);
	}
}
