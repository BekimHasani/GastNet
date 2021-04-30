package org.gastnet.clientmicro.service;

import javax.servlet.http.HttpServletRequest;

import org.gastnet.clientmicro.model.User;

public interface UserService {
	
	User getUserById(HttpServletRequest request, Long userId);
	
	User getUserByEmail(HttpServletRequest request, String userEmail);
}
