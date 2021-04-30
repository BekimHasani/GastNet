package org.gastnet.clientmicro.model;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expertise {

	private Long expertiseId;

	private String expertise;

	private Set<BusinessExpertise> businessExperience = new HashSet<>();

}
