package org.gastnet.gatewayservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

	private String state;

	private String city;

	private String address;

	private String description;
	
}
