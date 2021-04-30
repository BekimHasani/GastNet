package org.gastnet.individualmicro.event;

public class IndividualCreatedEvent {
	
	public final Long userId;	

	public IndividualCreatedEvent(Long userId ) {
		this.userId = userId;
	}
}
