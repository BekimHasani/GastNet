package org.gastnet.individualmicro.model;

import java.util.List;

import org.gastnet.individualmicro.entity.Individual;

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
