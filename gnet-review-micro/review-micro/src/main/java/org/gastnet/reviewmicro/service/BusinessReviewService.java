package org.gastnet.reviewmicro.service;

import org.gastnet.reviewmicro.entity.BusinessReview;

import java.util.List;

public interface BusinessReviewService {

    void save(BusinessReview businessReview);

    BusinessReview findById(long id);

    BusinessReview findByBusinessIdAndIndividualId(long businessId, long individualId);

    List<BusinessReview> findByBusinessId(long businessId);

    List<BusinessReview> findByIndividualId(long individualId);

    List<BusinessReview> findAll();

    void delete(BusinessReview businessReview);
}
