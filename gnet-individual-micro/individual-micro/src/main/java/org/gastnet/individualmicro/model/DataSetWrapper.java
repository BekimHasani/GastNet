package org.gastnet.individualmicro.model;

import java.util.Set;

import org.gastnet.individualmicro.entity.ProfessionalData;

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
