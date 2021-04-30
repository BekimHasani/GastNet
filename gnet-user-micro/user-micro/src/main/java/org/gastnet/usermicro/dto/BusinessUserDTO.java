package org.gastnet.usermicro.dto;

import org.gastnet.usermicro.entity.User;
import org.gastnet.usermicro.model.Business;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class BusinessUserDTO {

	private Business business;
	private User user;
}
