package org.gastnet.clientmicro.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class DataSetWrapper {
	
	private Set<ProfessionalData> data;
	
	public Set<ProfessionalData> getData(){
		return data;
	}
}
