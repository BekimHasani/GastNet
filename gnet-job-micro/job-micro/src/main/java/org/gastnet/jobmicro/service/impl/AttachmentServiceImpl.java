package org.gastnet.jobmicro.service.impl;

import org.gastnet.jobmicro.entity.Attachment;
import org.gastnet.jobmicro.entity.JobApplication;
import org.gastnet.jobmicro.repository.AttachmentRepository;
import org.gastnet.jobmicro.service.AttachmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public void save(Attachment attachment) {
        attachmentRepository.save(attachment);
    }

    @Override
    public Attachment findById(long id) {
        return attachmentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Attachment> findByJobApplication(JobApplication jobApplication) {
        return attachmentRepository.findByJobApplication(jobApplication);
    }

    @Override
    public List<Attachment> findAll() {
        return attachmentRepository.findAll();
    }

    @Override
    public void delete(Attachment attachment) {
        attachmentRepository.delete(attachment);
    }
}
