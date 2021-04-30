package org.gastnet.reviewmicro.service;

import org.gastnet.reviewmicro.entity.IndividualReview;

import java.util.List;

public interface IndividualReviewService {

    void save(IndividualReview individualReview);

    IndividualReview findById(long id);

    IndividualReview findByFromIndividualIdAndToIndividualId(long fromIndividualId, long toIndividualId);

    List<IndividualReview> findByFromIndividualId(long fromIndividualId);

    List<IndividualReview> findByToIndividualId(long toIndividualId);

    List<IndividualReview> findAll();

    void delete(IndividualReview individualReview);
}
