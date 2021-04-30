package org.gastnet.reviewmicro.repository;

import org.gastnet.reviewmicro.entity.ExpertiseReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertiseReviewRepository extends JpaRepository<ExpertiseReview, Long>{
	
}
