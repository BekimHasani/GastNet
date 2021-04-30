package org.gastnet.jobmicro.controller;

import lombok.extern.slf4j.Slf4j;
import org.gastnet.jobmicro.entity.Attachment;
import org.gastnet.jobmicro.entity.JobApplication;
import org.gastnet.jobmicro.exception.NotFoundException;
import org.gastnet.jobmicro.exception.ValidationException;
import org.gastnet.jobmicro.service.AttachmentService;
import org.gastnet.jobmicro.service.JobApplicationService;
import org.gastnet.jobmicro.utils.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.gastnet.jobmicro.validator.AttachmentValidator;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class AttachmentController {

    @Autowired
    private JobApplicationService jobApplicationService;
    @Autowired
    private AttachmentService attachmentService;
    @Autowired
    private AttachmentValidator attachmentValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        StringTrimmerEditor trimEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimEditor);
        dataBinder.addValidators(attachmentValidator);
    }

    @GetMapping("/attachment/{attachmentId}")
    public ResponseEntity<Attachment> get(@PathVariable("attachmentId") Long attachmentId) {
        Attachment attachment = attachmentService.findById(attachmentId);
        if (attachment == null) {
            throw new NotFoundException("Attachment not found");
        }
        return new ResponseEntity<>(attachment, HttpStatus.OK);
    }

    @GetMapping("/{jobApplicationId}/attachment")
    public ResponseEntity<List<Attachment>> getByJobApplicationId(@PathVariable("jobApplicationId") Long jobApplicationId) {
        JobApplication jobApplication = jobApplicationService.findById(jobApplicationId);
        if (jobApplication == null) {
            throw new NotFoundException("JobApplication not found");
        }
        return new ResponseEntity<List<Attachment>>(
                attachmentService.findByJobApplication(jobApplication),
                HttpStatus.OK);
    }

    @PostMapping("/{jobApplicationId}/attachment")
    public ResponseEntity<?> add(@Valid @RequestBody Attachment attachment,
                                 @PathVariable("jobApplicationId") Long jobApplicationId,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Errors in adding attachment {}, {}", attachment, bindingResult);
            throw new ValidationException("Error validating attachment",
                    ValidationUtils.getFieldErrors(bindingResult));
        }
        JobApplication jobApplication = jobApplicationService.findById(jobApplicationId);
        if (jobApplication == null) {
            throw new NotFoundException("Job application not found");
        }
        attachment.setJobApplication(jobApplication);
        attachmentService.save(attachment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/attachment/{attachmentId}")
    public ResponseEntity<?> update(@Valid @RequestBody Attachment attachment,
                                    @PathVariable("attachmentId") Long attachmentId,
                                    BindingResult bindingResult) {
        Attachment existingAttachment = attachmentService.findById(attachmentId);
        if (existingAttachment == null) {
            throw new NotFoundException("Attachment not found");
        }
        if (bindingResult.hasErrors()) {
            log.error("Errors in updating attachment {}, {}", attachment, bindingResult);
            throw new ValidationException("Error validating attachment",
                    ValidationUtils.getFieldErrors(bindingResult));
        }
        attachment.setAttachmentId(attachmentId); ;
        attachmentService.save(attachment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
