package org.gastnet.clientmicro.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SkillSetWrapper {

	private Set<IndividualSkill> skills;
	
	public Set<IndividualSkill> getSkills(){
		return skills;
	}
}
