package org.gastnet.usermicro.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.gastnet.usermicro.dto.IndividualUserDTO;

public class CreateUserForIndividualCommand {

	@TargetAggregateIdentifier
	public final String individualSagaId;
	
	public final IndividualUserDTO individualUserDTO;
	
	public CreateUserForIndividualCommand(String individualSagaId , IndividualUserDTO individualUserDTO) {
		this.individualSagaId = individualSagaId;
		this.individualUserDTO = individualUserDTO;
	}	
}
