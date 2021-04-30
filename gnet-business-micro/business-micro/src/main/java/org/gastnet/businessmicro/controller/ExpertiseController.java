package org.gastnet.businessmicro.controller;

import javax.validation.Valid;

import org.gastnet.businessmicro.entity.Expertise;
import org.gastnet.businessmicro.exception.NotFoundException;
import org.gastnet.businessmicro.exception.ValidationException;
import org.gastnet.businessmicro.service.ExpertiseService;
import org.gastnet.businessmicro.utils.ValidationUtils;
import org.gastnet.businessmicro.validator.ExpertiseValidator;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/expertises")
public class ExpertiseController {
	
    @Autowired
    private ExpertiseService expertiseService;
    @Autowired
    private ExpertiseValidator expertiseValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        StringTrimmerEditor trimEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimEditor);
        dataBinder.addValidators(expertiseValidator);
    }

    @GetMapping("/{expertiseId}")
    public ResponseEntity<Expertise> get(
            @PathVariable("expertiseId") Long expertiseId) {
        Expertise expertise = expertiseService.findById(expertiseId);
        if (expertise == null) {
            throw new NotFoundException("Expertise not found");
        }
        return new ResponseEntity<>(expertise, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> add(@Valid @RequestBody Expertise expertise,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Errors in adding expertise {}, {}", expertise, bindingResult);
            throw new ValidationException("Error validating expertise",
                    ValidationUtils.getFieldErrors(bindingResult));
        }
        expertiseService.save(expertise);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{expertiseId}")
    public ResponseEntity<?> update(@Valid @RequestBody Expertise expertise,
                                    @PathVariable("expertiseId") Long expertiseId,
                                    BindingResult bindingResult) {
        Expertise existingExpertise = expertiseService.findById(expertiseId);
        if (existingExpertise == null) {
            throw new NotFoundException("Expertise not found");
        }
        if (bindingResult.hasErrors()) {
            log.error("Errors in updating expertise {}, {}", expertise, bindingResult);
            throw new ValidationException("Error validating expertise",
                    ValidationUtils.getFieldErrors(bindingResult));
        }
        expertise.setExpertiseId(expertiseId); ;
        expertiseService.save(expertise);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
