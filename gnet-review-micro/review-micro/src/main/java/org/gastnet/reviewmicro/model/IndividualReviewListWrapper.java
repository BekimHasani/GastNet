package org.gastnet.reviewmicro.model;

import java.util.List;

import org.gastnet.reviewmicro.entity.IndividualReview;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class IndividualReviewListWrapper {

	private List<IndividualReview> individualReviews;
	
	public List<IndividualReview> getIndividualReviews(){
		return individualReviews;
	}
}
