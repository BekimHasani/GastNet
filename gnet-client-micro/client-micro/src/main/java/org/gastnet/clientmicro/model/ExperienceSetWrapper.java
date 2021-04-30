package org.gastnet.clientmicro.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ExperienceSetWrapper {

	private Set<Experience> experiences;
	
	public Set<Experience> getExperiences(){
		return experiences;
	}
}
