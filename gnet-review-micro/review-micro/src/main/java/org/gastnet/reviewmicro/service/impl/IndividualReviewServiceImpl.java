package org.gastnet.reviewmicro.service.impl;

import org.gastnet.reviewmicro.entity.IndividualReview;
import org.gastnet.reviewmicro.repository.IndividualReviewRepository;
import org.gastnet.reviewmicro.service.IndividualReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndividualReviewServiceImpl implements IndividualReviewService {

    @Autowired
    private IndividualReviewRepository individualReviewRepository;

    @Override
    public void save(IndividualReview individualReview) {
        individualReviewRepository.save(individualReview);
    }

    @Override
    public IndividualReview findById(long id) {
        return individualReviewRepository.findById(id).orElse(null);
    }

    @Override
    public IndividualReview findByFromIndividualIdAndToIndividualId(long fromIndividualId, long toIndividualId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<IndividualReview> findByFromIndividualId(long fromIndividualId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<IndividualReview> findByToIndividualId(long toIndividualId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<IndividualReview> findAll() {
        return individualReviewRepository.findAll();
    }

    @Override
    public void delete(IndividualReview individualReview) {
        individualReviewRepository.delete(individualReview);
    }
}
