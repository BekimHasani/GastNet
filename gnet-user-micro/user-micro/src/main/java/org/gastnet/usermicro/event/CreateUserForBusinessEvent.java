package org.gastnet.usermicro.event;

import org.gastnet.usermicro.dto.BusinessUserDTO;

public class CreateUserForBusinessEvent {

	public final String businessSagaId;

	public final  BusinessUserDTO businessUserDTO;

	public CreateUserForBusinessEvent(String businessSagaId, BusinessUserDTO businessUserDTO) {
		this.businessSagaId = businessSagaId;
		this.businessUserDTO = businessUserDTO;
	}
}
