package org.gastnet.usermicro.dto;

import org.gastnet.usermicro.entity.User;
import org.gastnet.usermicro.model.Individual;

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
