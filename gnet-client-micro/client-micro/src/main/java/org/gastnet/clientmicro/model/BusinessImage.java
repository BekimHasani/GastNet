package org.gastnet.clientmicro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessImage {

	private Long businessImageId;
	
	private String image;
	
	private Location location;
}
