package org.gastnet.jobmicro.service;

import org.gastnet.jobmicro.entity.JobOpening;

import java.util.List;

public interface JobOpeningService {

    void save(JobOpening jobOpening);

    JobOpening findById(long id);

    List<JobOpening> findAll();

    void delete(JobOpening jobOpening);
}
