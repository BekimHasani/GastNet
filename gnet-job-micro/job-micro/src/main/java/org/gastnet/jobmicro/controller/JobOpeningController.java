package org.gastnet.jobmicro.controller;

import lombok.extern.slf4j.Slf4j;
import org.gastnet.jobmicro.entity.JobOpening;
import org.gastnet.jobmicro.exception.NotFoundException;
import org.gastnet.jobmicro.exception.ValidationException;
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
import org.gastnet.jobmicro.validator.JobOpeningValidator;

import javax.validation.Valid;

@Slf4j
@RestController
public class JobOpeningController {

    @Autowired
    private JobOpeningService jobOpeningService;
    @Autowired
    private JobOpeningValidator jobOpeningValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        StringTrimmerEditor trimEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimEditor);
        dataBinder.addValidators(jobOpeningValidator);
    }

    @GetMapping("{id}")
    public ResponseEntity<JobOpening> get(@PathVariable("id") Long jobOpeningId) {
        JobOpening jobOpening = jobOpeningService.findById(jobOpeningId);
        if (jobOpening == null) {
            throw new NotFoundException("Job opening not found");
        }
        return new ResponseEntity<>(jobOpening, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobOpening jobOpening, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Errors in adding job opening {}, {}", jobOpening, bindingResult);
            throw new ValidationException("Error validating job opening",
                    ValidationUtils.getFieldErrors(bindingResult));
        }
        jobOpeningService.save(jobOpening);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long jobOpeningId,
                                    @Valid @RequestBody JobOpening jobOpening, BindingResult bindingResult) {
        JobOpening existingJobOpening = jobOpeningService.findById(jobOpeningId);
        if (existingJobOpening == null) {
            throw new NotFoundException("Job opening not found");
        }
        if (bindingResult.hasErrors()) {
            log.error("Errors in updating job opening {}, {}", jobOpening, bindingResult);
            throw new ValidationException("Error validating job opening",
                    ValidationUtils.getFieldErrors(bindingResult));
        }
        jobOpening.setJobId(jobOpeningId);
        jobOpeningService.save(jobOpening);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
