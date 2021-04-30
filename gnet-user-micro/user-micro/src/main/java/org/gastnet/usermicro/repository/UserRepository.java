package org.gastnet.usermicro.repository;

import java.util.List;

import org.gastnet.usermicro.entity.User;
import org.gastnet.usermicro.enumeration.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	
	List<User> findByRole(Role role);
	

}
