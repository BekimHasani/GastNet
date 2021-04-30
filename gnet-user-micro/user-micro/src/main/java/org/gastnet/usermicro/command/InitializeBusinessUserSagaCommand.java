package org.gastnet.usermicro.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.gastnet.usermicro.dto.BusinessUserDTO;

public class InitializeBusinessUserSagaCommand {

	@TargetAggregateIdentifier
	public final String businessSagaId;

	public final  BusinessUserDTO businessUserDTO;

	public InitializeBusinessUserSagaCommand(String businessSagaId, BusinessUserDTO businessUserDTO) {
		this.businessSagaId = businessSagaId;
		this.businessUserDTO = businessUserDTO;
	}
}
