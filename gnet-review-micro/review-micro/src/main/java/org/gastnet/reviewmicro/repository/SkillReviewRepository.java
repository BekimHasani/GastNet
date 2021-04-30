package org.gastnet.reviewmicro.repository;

import org.gastnet.reviewmicro.entity.SkillReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillReviewRepository extends JpaRepository<SkillReview, Long> {

}
