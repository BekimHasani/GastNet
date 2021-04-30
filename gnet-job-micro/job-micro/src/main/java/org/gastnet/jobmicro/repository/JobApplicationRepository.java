package org.gastnet.jobmicro.repository;

import org.gastnet.jobmicro.entity.JobApplication;
import org.gastnet.jobmicro.entity.JobOpening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

    List<JobApplication> findByJobOpening(JobOpening jobOpening);
}
