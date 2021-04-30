package org.gastnet.reviewmicro.service.impl;

import org.gastnet.reviewmicro.entity.BusinessIndividualReview;
import org.gastnet.reviewmicro.repository.BusinessIndividualReviewRepository;
import org.gastnet.reviewmicro.service.BusinessIndividualReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessIndividualReviewServiceImpl implements BusinessIndividualReviewService {

    @Autowired
    private BusinessIndividualReviewRepository businessIndividualReviewRepository;

    @Override
    public void save(BusinessIndividualReview businessIndividualReview) {
        businessIndividualReviewRepository.save(businessIndividualReview);
    }

    @Override
    public BusinessIndividualReview findById(long id) {
        return businessIndividualReviewRepository.findById(id).orElse(null);
    }

    @Override
    public BusinessIndividualReview findByBusinessIdAndIndividualId(long businessId, long individualId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<BusinessIndividualReview> findByIndividualId(long individualId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<BusinessIndividualReview> findByBusinessId(long businessId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<BusinessIndividualReview> findAll() {
        return businessIndividualReviewRepository.findAll();
    }

    @Override
    public void delete(BusinessIndividualReview businessIndividualReview) {
        businessIndividualReviewRepository.delete(businessIndividualReview);
    }
}
