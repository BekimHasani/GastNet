package org.gastnet.usermicro.event;

public class IndividualCreatedEvent {

	public final Long userId;

	public IndividualCreatedEvent(Long userId) {
		this.userId = userId;
	}
}
