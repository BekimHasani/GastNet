package org.gastnet.clientmicro.model;

import java.util.Date;

import org.gastnet.clientmicro.enumeration.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private Long userId;
	
	private String email;
	
	private String password;
	
	private String retryPassword;

	private Date creationDate;
	
	private boolean status;
	
	private Role role;
}
