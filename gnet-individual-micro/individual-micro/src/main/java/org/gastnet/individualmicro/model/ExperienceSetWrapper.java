package org.gastnet.individualmicro.model;

import java.util.Set;

import org.gastnet.individualmicro.entity.Experience;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ExperienceSetWrapper {
	
	private Set<Experience> experiences;
	
	public Set<Experience> getExperiences(){
		return experiences;
	}
}
