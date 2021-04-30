package org.gastnet.reviewmicro.service;


import java.util.List;

import org.gastnet.reviewmicro.entity.ExpertiseReview;

public interface ExpertiseReviewService {


    ExpertiseReview save(ExpertiseReview expertiseReview);

    ExpertiseReview findById(long id);

    ExpertiseReview findByBusinessIdAndIndividualId(long businessId, long individualId);

    List<ExpertiseReview> findByIndividualId(long individualId);

    List<ExpertiseReview> findByBusinessId(long businessId);

    List<ExpertiseReview> findAll();

    void delete(ExpertiseReview expertiseReview);
}
