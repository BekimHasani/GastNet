package org.gastnet.usermicro.event;

import org.gastnet.usermicro.dto.IndividualUserDTO;

public class UserForIndividualCreatedEvent {

	public final String individualSagaId;
	
	public final IndividualUserDTO individualUserDTO;

	public UserForIndividualCreatedEvent(String individualSagaId , IndividualUserDTO individualUserDTO) {
		this.individualSagaId = individualSagaId;
		this.individualUserDTO = individualUserDTO;
	}
}
