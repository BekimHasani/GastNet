package org.gastnet.usermicro.model;

import java.util.List;

import org.gastnet.usermicro.entity.User;

public class UserListWrapper {

	List<User> users;
	
	public UserListWrapper(List<User> users) {
		this.users = users;
	}
	
	public List<User> getUsers() {
		return users;
	}
}
