package org.gastnet.jobmicro.repository;

import org.gastnet.jobmicro.entity.JobOpening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobOpeningRepository extends JpaRepository<JobOpening, Long> {
}
