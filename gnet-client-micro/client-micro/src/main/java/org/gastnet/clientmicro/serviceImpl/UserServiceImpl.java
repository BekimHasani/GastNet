package org.gastnet.clientmicro.serviceImpl;

import javax.servlet.http.HttpServletRequest;

import org.gastnet.clientmicro.enumeration.URL;
import org.gastnet.clientmicro.model.User;
import org.gastnet.clientmicro.service.UserService;
import org.gastnet.clientmicro.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public User getUserById(HttpServletRequest request, Long userId) {
		log.info("Retrviving a specific User by id form user database table");
		ResponseEntity<User> response = restTemplate.exchange(RequestUtils.getAuthorizedGetRequest(request, 
				RequestUtils.getURI(URL.USER,"id/"+userId)), User.class);
		return response.getBody();
	}

	@Override
	public User getUserByEmail(HttpServletRequest request, String userEmail) {
		log.info("Retrviving a specific User by email form user database table");
		ResponseEntity<User> response = restTemplate.exchange(RequestUtils.getAuthorizedGetRequest(request, 
				RequestUtils.getURI(URL.USER,"user/"+userEmail)), User.class);
		return response.getBody() ;
	}

}
