package org.gastnet.reviewmicro.repository;

import org.gastnet.reviewmicro.entity.IndividualReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndividualReviewRepository extends JpaRepository<IndividualReview, Long> {
}
