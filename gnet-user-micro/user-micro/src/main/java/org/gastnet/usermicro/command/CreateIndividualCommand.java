package org.gastnet.usermicro.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.gnet.common.model.Individual;

public class CreateIndividualCommand {
	
	@TargetAggregateIdentifier
	public final Long userId;
	
	public final Individual individual;
	
	public CreateIndividualCommand(Long userId , Individual individual) {
		this.userId = userId;
		this.individual = individual;
	}	
}
