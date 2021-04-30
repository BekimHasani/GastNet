package org.gastnet.reviewmicro.service;

import org.gastnet.reviewmicro.entity.BusinessIndividualReview;

import java.util.List;

public interface BusinessIndividualReviewService {

	void save(BusinessIndividualReview businessIndividualReview);

    BusinessIndividualReview findById(long id);

    BusinessIndividualReview findByBusinessIdAndIndividualId(long businessId, long individualId);

    List<BusinessIndividualReview> findByIndividualId(long individualId);

    List<BusinessIndividualReview> findByBusinessId(long businessId);

    List<BusinessIndividualReview> findAll();

    void delete(BusinessIndividualReview businessIndividualReview);
}
