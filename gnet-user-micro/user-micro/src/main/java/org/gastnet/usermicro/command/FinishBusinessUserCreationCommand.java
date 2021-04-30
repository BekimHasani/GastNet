package org.gastnet.usermicro.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class FinishBusinessUserCreationCommand {
	
	@TargetAggregateIdentifier
	public final Long userId;

	public FinishBusinessUserCreationCommand(Long userId) {
		this.userId = userId;
	}

}
