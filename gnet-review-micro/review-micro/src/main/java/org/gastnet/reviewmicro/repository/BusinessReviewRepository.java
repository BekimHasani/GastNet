package org.gastnet.reviewmicro.repository;

import org.gastnet.reviewmicro.entity.BusinessReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessReviewRepository extends JpaRepository<BusinessReview, Long> {
}
