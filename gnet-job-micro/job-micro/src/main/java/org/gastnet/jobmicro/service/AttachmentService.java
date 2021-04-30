package org.gastnet.jobmicro.service;

import org.gastnet.jobmicro.entity.Attachment;
import org.gastnet.jobmicro.entity.JobApplication;

import java.util.List;

public interface AttachmentService {

    void save(Attachment attachment);

    Attachment findById(long id);

    List<Attachment> findByJobApplication(JobApplication jobApplication);

    List<Attachment> findAll();

    void delete(Attachment attachment);
}
