package org.gastnet.clientmicro.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BusinessListWrapper {

	List<Business> businesses;
	
	public List<Business> getBusinesses(){
		return businesses;
	}
}
