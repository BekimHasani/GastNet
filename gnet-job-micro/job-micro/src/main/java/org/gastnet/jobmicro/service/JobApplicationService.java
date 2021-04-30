package org.gastnet.jobmicro.service;

import org.gastnet.jobmicro.entity.JobApplication;
import org.gastnet.jobmicro.entity.JobOpening;

import java.util.List;

public interface JobApplicationService {

    void save(JobApplication jobApplication);

    JobApplication findById(long id);

    List<JobApplication> findByJobOpening(JobOpening jobOpening);

    List<JobApplication> findAll();

    void delete(JobApplication jobApplication);
}
