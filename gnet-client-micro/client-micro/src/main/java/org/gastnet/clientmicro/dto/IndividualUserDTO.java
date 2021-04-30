package org.gastnet.clientmicro.dto;

import org.gastnet.clientmicro.model.Individual;
import org.gastnet.clientmicro.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndividualUserDTO {
	
	private User user;
	
	private Individual individual;
	
}
