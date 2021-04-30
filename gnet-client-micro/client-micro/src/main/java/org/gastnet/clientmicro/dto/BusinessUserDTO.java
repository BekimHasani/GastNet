package org.gastnet.clientmicro.dto;

import org.gastnet.clientmicro.model.Business;
import org.gastnet.clientmicro.model.Contact;
import org.gastnet.clientmicro.model.Location;
import org.gastnet.clientmicro.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessUserDTO {
	
	private Business business;
	private User user;
	private Location location;
	private Contact emailContact;
	private Contact phoneContact;
	
	public BusinessUserDTO(Business business, User user) {
		this.business = business;
		this.user = user;
	}
}
