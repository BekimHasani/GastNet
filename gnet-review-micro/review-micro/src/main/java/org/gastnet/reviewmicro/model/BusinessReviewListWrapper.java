package org.gastnet.reviewmicro.model;

import java.util.List;

import org.gastnet.reviewmicro.entity.BusinessReview;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class BusinessReviewListWrapper {

	List<BusinessReview> businessReviews;
	
	public List<BusinessReview> getBusinessReviews() {
		return businessReviews;
	}
}
