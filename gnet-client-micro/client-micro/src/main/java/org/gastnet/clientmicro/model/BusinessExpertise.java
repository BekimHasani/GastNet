package org.gastnet.clientmicro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessExpertise {

	private Long businessExpertiseId;
	private String description;
	private String expertise;

}
