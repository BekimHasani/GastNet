package org.gastnet.usermicro.event;

import org.gastnet.usermicro.dto.BusinessUserDTO;

public class UserForBusinessCreatedEvent {

	public final String businessSagaId;
	
	public final BusinessUserDTO businessUserDTO;
	
	public UserForBusinessCreatedEvent(String businessSagaId , BusinessUserDTO businessUserDTO) {
		this.businessSagaId = businessSagaId;
		this.businessUserDTO = businessUserDTO;
	}	
}
