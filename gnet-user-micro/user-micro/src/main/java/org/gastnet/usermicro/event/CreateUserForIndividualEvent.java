package org.gastnet.usermicro.event;

import org.gastnet.usermicro.dto.IndividualUserDTO;

public class CreateUserForIndividualEvent {
	
	public final String individualSagaId;

	public final  IndividualUserDTO individualUserDTO;

	public CreateUserForIndividualEvent(String individualSagaId, IndividualUserDTO individualUserDTO) {
		this.individualSagaId = individualSagaId;
		this.individualUserDTO = individualUserDTO;
	}
}
