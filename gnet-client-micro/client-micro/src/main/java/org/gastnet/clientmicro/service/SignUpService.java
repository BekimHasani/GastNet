package org.gastnet.clientmicro.service;

import org.gastnet.clientmicro.dto.BusinessUserDTO;
import org.gastnet.clientmicro.dto.IndividualUserDTO;
import org.springframework.validation.BindingResult;

public interface SignUpService {
	
	void individualSignUp(IndividualUserDTO individualUserDTO,BindingResult bindingResult);
	void businessSignUp(BusinessUserDTO businessUserDTO,BindingResult bindingResult);
}
