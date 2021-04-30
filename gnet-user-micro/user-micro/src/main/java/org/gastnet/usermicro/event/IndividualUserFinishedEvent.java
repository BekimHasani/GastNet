package org.gastnet.usermicro.event;

public class IndividualUserFinishedEvent {
	
	public final Long userId;
	
	public final String email;

	public IndividualUserFinishedEvent(String email,Long userId) {
		this.email = email;
		this.userId = userId;
	}
}
