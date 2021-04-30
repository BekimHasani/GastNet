package org.gastnet.reviewmicro.controller;

import javax.validation.Valid;

import org.gastnet.reviewmicro.entity.SkillReview;
import org.gastnet.reviewmicro.exception.NotFoundException;
import org.gastnet.reviewmicro.exception.ValidationException;
import org.gastnet.reviewmicro.model.SkillReviewListWrapper;
import org.gastnet.reviewmicro.service.SkillReviewService;
import org.gastnet.reviewmicro.utils.ValidationUtils;
import org.gastnet.reviewmicro.validator.SkillReviewValidator;
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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SkillReviewController {

    @Autowired
    private SkillReviewService skillReviewService;
    
    @Autowired 
    private SkillReviewValidator validator;
    
    @InitBinder
    public void init(WebDataBinder dataBinder) {
    	StringTrimmerEditor trimerEditor = new StringTrimmerEditor(true);
    	dataBinder.registerCustomEditor(String.class,trimerEditor);
    	dataBinder.addValidators(validator);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<SkillReview> get(@PathVariable("id") Long skillReviewId){
    	SkillReview skillReview = skillReviewService.findById(skillReviewId);
    	if(skillReview == null) {
    		throw new NotFoundException("SkillReview not found");
    	}
    	return new ResponseEntity<>(skillReview, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody SkillReview skillReview, 
    		BindingResult bindingResult){
    	if(bindingResult.hasErrors()) {
    		log.error("Error in adding SkillReview {}, {}", skillReview, bindingResult );
    		throw new ValidationException("Error validating SkillReview", ValidationUtils.getFieldErrors(bindingResult));
    	}
    	skillReviewService.save(skillReview);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long skillReviewId, 
    		@Valid @RequestBody SkillReview skillReview, BindingResult bindingResult){
    	SkillReview sr = skillReviewService.findById(skillReviewId);
    	if(sr == null) {
    		throw new NotFoundException("SkillReview not found");
    	}
    	if(bindingResult.hasErrors()) {
    		log.error("Error validating SkillReview {}, {}", skillReview, bindingResult);
    		throw new ValidationException("Error validating SkillReview",ValidationUtils.getFieldErrors(bindingResult));
    	}
    	skillReview.setId(skillReviewId);
    	skillReviewService.save(skillReview);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/")
    public ResponseEntity<SkillReviewListWrapper> skillReviews() {
    	SkillReviewListWrapper skillReviews= new SkillReviewListWrapper(skillReviewService.findAll());
    	return new ResponseEntity<>(skillReviews, HttpStatus.OK);
    }
}
