package org.gastnet.reviewmicro.model;

import java.util.List;

import org.gastnet.reviewmicro.entity.ExpertiseReview;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ExpertiseReviewListWrapper {

	private List<ExpertiseReview> expertiseReviews;
	
	public List<ExpertiseReview> getExpertiseReviews(){
		return expertiseReviews;
	}
}
