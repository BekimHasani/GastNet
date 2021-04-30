package org.gastnet.gatewayservice.dto;

import org.gastnet.gatewayservice.model.Individual;
import org.gastnet.gatewayservice.model.User;

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
