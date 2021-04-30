package org.gastnet.reviewmicro.service.impl;

import org.gastnet.reviewmicro.entity.SkillReview;
import org.gastnet.reviewmicro.repository.SkillReviewRepository;
import org.gastnet.reviewmicro.service.SkillReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillReviewServiceImpl implements SkillReviewService {

    @Autowired
    private SkillReviewRepository skillReviewRepository;

    @Override
    public void save(SkillReview skillReview) {
        skillReviewRepository.save(skillReview);
    }

    @Override
    public SkillReview findById(long id) {
        return skillReviewRepository.findById(id).orElse(null);
    }

    @Override
    public SkillReview findByIndividualIdAndIndividualSkillId(long individualId, long individualSkillId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<SkillReview> findByIndividualId(long individualId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<SkillReview> findByIndividualSkillId(long individualSkillId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<SkillReview> findAll() {
        return skillReviewRepository.findAll();
    }

    @Override
    public void delete(SkillReview skillReview) {
        skillReviewRepository.delete(skillReview);
    }
}
