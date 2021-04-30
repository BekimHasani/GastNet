package org.gastnet.clientmicro.serviceImpl;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.gastnet.clientmicro.config.jwt.JwtConverter;
import org.gastnet.clientmicro.enumeration.Role;
import org.gastnet.clientmicro.enumeration.URL;
import org.gastnet.clientmicro.model.Individual;
import org.gastnet.clientmicro.model.User;
import org.gastnet.clientmicro.model.UserCredentials;
import org.gastnet.clientmicro.service.AuthenticationService;
import org.gastnet.clientmicro.service.IndividualService;
import org.gastnet.clientmicro.service.UserService;
import org.gastnet.clientmicro.session.IndividualCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private IndividualService individualService;
	
	@Autowired
	private UserService userService;

	public void getUserToken(UserCredentials user, HttpServletRequest request) throws HttpClientErrorException {
		
		ResponseEntity<String> response = restTemplate.postForEntity(URL.LOGIN.getValue(),  user, String.class);
		HttpSession session = request.getSession();
		
		String token = response.getHeaders().getFirst("Authorization").toString();
		
		session.setAttribute("token", token);
		session.setAttribute("individualCredentials", loadSession(request, token) );
	}

	public void invalidateUserToken(HttpServletRequest request) {
		HttpSession session = request.getSession();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", session.getAttribute("token").toString());

		HttpEntity<String> entity = new HttpEntity<>(headers);

		restTemplate.postForEntity(URL.LOGOUT.getValue(), entity, String.class);
		session.invalidate();
	}

	private IndividualCredentials loadSession(HttpServletRequest request, String token) {	
		JwtConverter jwt = new JwtConverter();
		String [] content = jwt.getUserEmailFromToken(token).split("/");
		User user = userService.getUserByEmail(request, content[0]);
		Individual individual = individualService.getIndividualByUserId(request, user.getUserId());
		return new IndividualCredentials(user.getUserId(), individual.getIndividualId(), content[0], Enum.valueOf(Role.class, content[1]));
	}
	
}
