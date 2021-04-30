package org.gastnet.individualmicro.utils;

import org.gastnet.individualmicro.entity.Individual;
import org.gastnet.individualmicro.enumeration.IndividualType;

public class SagaUtils {
	private SagaUtils() {
	}

	public static Individual convertToIndividualEntity(org.gnet.common.model.Individual individual) {
		Individual entity = new Individual();
		entity.setBirthDate(individual.getBirthDate());
		entity.setLastName(individual.getLastName());
		entity.setName(individual.getName());
		entity.setState(individual.getState());
		entity.setCity(individual.getCity());
		entity.setGender(individual.getGender());
		entity.setPhoneNumber(individual.getPhoneNumber());
		entity.setIndividualType(IndividualType.valueOf(individual.getIndividualType().toString()));
		return entity;
	}
	
}
