package org.gastnet.individualmicro.model;

import java.util.Set;
import org.gastnet.individualmicro.entity.IndividualSkill;
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
