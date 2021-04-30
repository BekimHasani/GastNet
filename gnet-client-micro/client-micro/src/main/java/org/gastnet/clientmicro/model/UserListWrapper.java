package org.gastnet.clientmicro.model;

import java.util.List;

public class UserListWrapper {

	private List<User> users; 
	
	public UserListWrapper() {	
	}

	public UserListWrapper(List<User> users) {
		this.users = users;
	}
	
	public List<User> getUsers(){
		return users;
	}
}
