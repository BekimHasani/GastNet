package org.gastnet.gatewayservice.service;

import org.gastnet.gatewayservice.model.User;
import org.gastnet.gatewayservice.model.UserPrincipals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService{

	@Autowired 
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.gatUserByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Error: 404 - User doesn't exists");
		}
		return new UserPrincipals(user);
	}
	
	
}
