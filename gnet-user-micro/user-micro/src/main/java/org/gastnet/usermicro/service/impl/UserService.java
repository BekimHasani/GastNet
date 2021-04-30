package org.gastnet.usermicro.service.impl;

import java.util.List;

import org.gastnet.usermicro.entity.User;
import org.gastnet.usermicro.enumeration.Role;

public interface UserService {
	
	User save(User user);
	
	User findById(long userId);
	
	List<User> findAll();

	User getUserByEmail(String email);
	
	List<User> findByRole(Role role);
}
