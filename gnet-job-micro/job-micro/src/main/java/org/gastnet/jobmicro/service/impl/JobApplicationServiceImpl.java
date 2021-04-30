package org.gastnet.jobmicro.service.impl;

import org.gastnet.jobmicro.entity.JobApplication;
import org.gastnet.jobmicro.entity.JobOpening;
import org.gastnet.jobmicro.repository.JobApplicationRepository;
import org.gastnet.jobmicro.service.JobApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;

    public JobApplicationServiceImpl(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    @Override
    public void save(JobApplication jobApplication) {
        jobApplicationRepository.save(jobApplication);
    }

    @Override
    public JobApplication findById(long id) {
        return jobApplicationRepository.findById(id).orElse(null);
    }

    @Override
    public List<JobApplication> findByJobOpening(JobOpening jobOpening) {
        return jobApplicationRepository.findByJobOpening(jobOpening);
    }

    @Override
    public List<JobApplication> findAll() {
        return jobApplicationRepository.findAll();
    }

    @Override
    public void delete(JobApplication jobApplication) {
        jobApplicationRepository.delete(jobApplication);
    }
}
