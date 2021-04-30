package org.gastnet.jobmicro.repository;

import org.gastnet.jobmicro.entity.Attachment;
import org.gastnet.jobmicro.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
    List<Attachment> findByJobApplication(JobApplication jobApplication);
}
