package org.gastnet.reviewmicro.model;

import java.util.List;

import org.gastnet.reviewmicro.entity.SkillReview;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SkillReviewListWrapper {

	private List<SkillReview> skillReviews;
	
	public List<SkillReview> getSkillReviews(){
		return skillReviews;
	}
}
