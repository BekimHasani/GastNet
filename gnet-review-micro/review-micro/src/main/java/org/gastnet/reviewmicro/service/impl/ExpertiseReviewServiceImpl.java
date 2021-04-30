package org.gastnet.reviewmicro.service.impl;


import java.util.List;

import org.gastnet.reviewmicro.entity.ExpertiseReview;
import org.gastnet.reviewmicro.repository.ExpertiseReviewRepository;
import org.gastnet.reviewmicro.service.ExpertiseReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpertiseReviewServiceImpl implements ExpertiseReviewService {

    @Autowired
    private ExpertiseReviewRepository expertiseReviewRepository;

    
    @Override
    public ExpertiseReview save(ExpertiseReview expertiseReview){
        return expertiseReviewRepository.save(expertiseReview);
    }

    @Override
    public ExpertiseReview findById(long id) {
        return expertiseReviewRepository.findById(id).orElse(null);
    }

    @Override
    public ExpertiseReview findByBusinessIdAndIndividualId(long businessId, long individualId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<ExpertiseReview> findByIndividualId(long individualId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<ExpertiseReview> findByBusinessId(long businessId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<ExpertiseReview> findAll() {
        return expertiseReviewRepository.findAll();
    }

    @Override
    public void delete(ExpertiseReview expertiseReview) {
        expertiseReviewRepository.delete(expertiseReview);
    }
}
