package org.gastnet.usermicro.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.gastnet.usermicro.dto.IndividualUserDTO;

public class InitializeIndividualUserSagaCommand {

	@TargetAggregateIdentifier
	public final String individualSagaId;

	public final  IndividualUserDTO individualUserDTO;

	public InitializeIndividualUserSagaCommand(String individualSagaId, IndividualUserDTO individualUserDTO) {
		super();
		this.individualSagaId = individualSagaId;
		this.individualUserDTO = individualUserDTO;
	}
	
}
