package org.gastnet.usermicro.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class FinishIndividualUserCreationCommand {
	
	@TargetAggregateIdentifier
	public final Long userId;

	public FinishIndividualUserCreationCommand(Long userId) {
		this.userId = userId;
	}

}
