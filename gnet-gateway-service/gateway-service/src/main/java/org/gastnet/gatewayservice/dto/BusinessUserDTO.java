package org.gastnet.gatewayservice.dto;

import org.gastnet.gatewayservice.model.Business;
import org.gastnet.gatewayservice.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessUserDTO {

	private Business business;
	
	private User user;
}
