package org.gastnet.reviewmicro.repository;

import org.gastnet.reviewmicro.entity.BusinessIndividualReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessIndividualReviewRepository extends JpaRepository<BusinessIndividualReview, Long> {
}
