package org.gastnet.clientmicro.session;

import org.gastnet.clientmicro.enumeration.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualCredentials {

	private Long userId;
	private Long individualId;
	private String email;
	private Role role;	
}
