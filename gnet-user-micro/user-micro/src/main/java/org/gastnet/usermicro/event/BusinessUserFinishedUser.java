package org.gastnet.usermicro.event;

public class BusinessUserFinishedUser {

	public final Long userId;

	public final String email;

	public BusinessUserFinishedUser(String email, Long userId) {
		this.email = email;
		this.userId = userId;
	}
}
