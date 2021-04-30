package org.gastnet.usermicro.command.service;

import java.util.concurrent.CompletableFuture;

import org.gastnet.usermicro.dto.BusinessUserDTO;
import org.gastnet.usermicro.dto.IndividualUserDTO;

public interface UserCommandService {

	CompletableFuture<Long> saveIndividualUser(IndividualUserDTO individualUserDTO); 
	CompletableFuture<Long> saveBusinessUser(BusinessUserDTO businessUserDTO); 
}
