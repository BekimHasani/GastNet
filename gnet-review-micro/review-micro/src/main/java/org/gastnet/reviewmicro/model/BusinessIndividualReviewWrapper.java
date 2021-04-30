package org.gastnet.reviewmicro.model;

import java.util.List;

import org.gastnet.reviewmicro.entity.BusinessIndividualReview;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class BusinessIndividualReviewWrapper {

	List<BusinessIndividualReview> businessIndividualReviews;
	
	public List<BusinessIndividualReview> getBusinessIndividualReviews(){
		return businessIndividualReviews;
	}
}
