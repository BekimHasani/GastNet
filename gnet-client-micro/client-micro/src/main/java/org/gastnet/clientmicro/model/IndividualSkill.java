package org.gastnet.clientmicro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndividualSkill {
	
	private Long id;

	private String skill;
	
	private Individual individual;
}
