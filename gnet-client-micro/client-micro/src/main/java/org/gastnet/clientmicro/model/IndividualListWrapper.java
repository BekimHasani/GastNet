package org.gastnet.clientmicro.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class IndividualListWrapper {

	List<Individual> individuals;
	
	public List<Individual> getIndividuals() {
		return individuals;
	}
}
