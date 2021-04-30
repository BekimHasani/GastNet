package org.gastnet.usermicro.service;

import java.util.List;

import javax.transaction.Transactional;
import org.gastnet.usermicro.entity.User;
import org.gastnet.usermicro.enumeration.Role;
import org.gastnet.usermicro.repository.UserRepository;
import org.gastnet.usermicro.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findById(long userId) {
		return userRepository.findById(userId).orElse(null);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findByRole(Role role) {
		return userRepository.findByRole(role);
	}

}
