package org.gastnet.businessmicro.model;

import java.util.List;

import org.gastnet.businessmicro.entity.Business;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class BusinessListWrapper {

	List<Business> businesses;
	
	public List<Business> getBusinesses(){
		return businesses;
	}
}
