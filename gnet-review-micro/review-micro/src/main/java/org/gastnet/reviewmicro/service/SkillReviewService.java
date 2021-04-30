package org.gastnet.reviewmicro.service;

import org.gastnet.reviewmicro.entity.SkillReview;

import java.util.List;

public interface SkillReviewService {

    void save(SkillReview skillReview);

    SkillReview findById(long id);

    SkillReview findByIndividualIdAndIndividualSkillId(long individualId, long individualSkillId);

    List<SkillReview> findByIndividualId(long individualId);

    List<SkillReview> findByIndividualSkillId(long individualSkillId);

    List<SkillReview> findAll();

    void delete(SkillReview skillReview);
}
