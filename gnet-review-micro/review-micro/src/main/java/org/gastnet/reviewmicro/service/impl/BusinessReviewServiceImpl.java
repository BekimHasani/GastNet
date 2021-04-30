package org.gastnet.reviewmicro.service.impl;

import org.gastnet.reviewmicro.entity.BusinessReview;
import org.gastnet.reviewmicro.repository.BusinessReviewRepository;
import org.gastnet.reviewmicro.service.BusinessReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessReviewServiceImpl implements BusinessReviewService {

    @Autowired
    private BusinessReviewRepository businessReviewRepository;

    @Override
    public void save(BusinessReview businessReview) {
        businessReviewRepository.save(businessReview);
    }

    @Override
    public BusinessReview findById(long id) {
        return businessReviewRepository.findById(id).orElse(null);
    }

    @Override
    public BusinessReview findByBusinessIdAndIndividualId(long businessId, long individualId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<BusinessReview> findByBusinessId(long businessId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<BusinessReview> findByIndividualId(long individualId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<BusinessReview> findAll() {
        return businessReviewRepository.findAll();
    }

    @Override
    public void delete(BusinessReview businessReview) {
        businessReviewRepository.delete(businessReview);
    }
}
