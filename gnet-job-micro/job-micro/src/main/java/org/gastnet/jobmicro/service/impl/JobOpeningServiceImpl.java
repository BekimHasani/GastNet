package org.gastnet.jobmicro.service.impl;

import org.gastnet.jobmicro.entity.JobOpening;
import org.gastnet.jobmicro.repository.JobOpeningRepository;
import org.gastnet.jobmicro.service.JobOpeningService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobOpeningServiceImpl implements JobOpeningService {

    private final JobOpeningRepository jobOpeningRepository;

    public JobOpeningServiceImpl(JobOpeningRepository jobOpeningRepository) {
        this.jobOpeningRepository = jobOpeningRepository;
    }

    @Override
    public void save(JobOpening jobOpening) {
        jobOpeningRepository.save(jobOpening);
    }

    @Override
    public JobOpening findById(long id) {
        return jobOpeningRepository.findById(id).orElse(null);
    }

    @Override
    public List<JobOpening> findAll() {
        return jobOpeningRepository.findAll();
    }

    @Override
    public void delete(JobOpening jobOpening) {
        jobOpeningRepository.delete(jobOpening);
    }
}
