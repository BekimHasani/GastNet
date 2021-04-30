package org.gastnet.jobmicro.controller;

import lombok.extern.slf4j.Slf4j;
import org.gastnet.jobmicro.entity.JobApplication;
import org.gastnet.jobmicro.entity.JobOpening;
import org.gastnet.jobmicro.exception.NotFoundException;
import org.gastnet.jobmicro.exception.ValidationException;
import org.gastnet.jobmicro.service.JobApplicationService;
import org.gastnet.jobmicro.service.JobOpeningService;
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
import org.gastnet.jobmicro.validator.JobApplicationValidator;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class JobApplicationController {

    @Autowired
    private JobOpeningService jobOpeningService;
    @Autowired
    private JobApplicationService jobApplicationService;
    @Autowired
    private JobApplicationValidator jobApplicationValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        StringTrimmerEditor trimEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimEditor);
        dataBinder.addValidators(jobApplicationValidator);
    }

    @GetMapping("/application/{jobApplicationId}")
    public ResponseEntity<JobApplication> get(@PathVariable("jobApplicationId") Long jobApplicationId) {
        JobApplication jobApplication = jobApplicationService.findById(jobApplicationId);
        if (jobApplication == null) {
            throw new NotFoundException("Job application not found");
        }
        return new ResponseEntity<>(jobApplication, HttpStatus.OK);
    }

    @GetMapping("/{jobOpeningId}/application")
    public ResponseEntity<List<JobApplication>> getByJobOpeningId(@PathVariable("jobOpeningId") Long jobOpeningId) {
        JobOpening jobOpening = jobOpeningService.findById(jobOpeningId);
        if (jobOpening == null) {
            throw new NotFoundException("Job opening not found");
        }
        return new ResponseEntity<List<JobApplication>>(
                jobApplicationService.findByJobOpening(jobOpening),
                HttpStatus.OK);
    }

    @PostMapping("/{jobOpeningId}/application")
    public ResponseEntity<?> add(@Valid @RequestBody JobApplication jobApplication,
                                 @PathVariable("jobOpeningId") Long jobOpeningId,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Errors in adding job application {}, {}", jobApplication, bindingResult);
            throw new ValidationException("Error validating job application",
                    ValidationUtils.getFieldErrors(bindingResult));
        }
        JobOpening jobOpening = jobOpeningService.findById(jobOpeningId);
        if (jobOpening == null) {
            throw new NotFoundException("Job opening not found");
        }
        jobApplication.setJobOpening(jobOpening);
        jobApplicationService.save(jobApplication);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/application/{jobApplicationId}")
    public ResponseEntity<?> update(@Valid @RequestBody JobApplication jobApplication,
                                    @PathVariable("jobApplicationId") Long jobApplicationId,
                                    BindingResult bindingResult) {
        JobApplication existingJobApplication = jobApplicationService.findById(jobApplicationId);
        if (existingJobApplication == null) {
            throw new NotFoundException("Job application not found");
        }
        if (bindingResult.hasErrors()) {
            log.error("Errors in updating job application {}, {}", jobApplication, bindingResult);
            throw new ValidationException("Error validating job application",
                    ValidationUtils.getFieldErrors(bindingResult));
        }
        jobApplication.setApplicationId(jobApplicationId); ;
        jobApplicationService.save(jobApplication);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
