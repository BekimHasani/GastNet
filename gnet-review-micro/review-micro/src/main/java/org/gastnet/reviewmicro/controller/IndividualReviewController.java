package org.gastnet.reviewmicro.controller;

import javax.validation.Valid;

import org.gastnet.reviewmicro.entity.IndividualReview;
import org.gastnet.reviewmicro.exception.NotFoundException;
import org.gastnet.reviewmicro.exception.ValidationException;
import org.gastnet.reviewmicro.model.IndividualReviewListWrapper;
import org.gastnet.reviewmicro.service.IndividualReviewService;
import org.gastnet.reviewmicro.utils.ValidationUtils;
import org.gastnet.reviewmicro.validator.IndividualReviewValidator;
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
public class IndividualReviewController {

    @Autowired
    private IndividualReviewService individualReviewService;
    
    @Autowired 
    private IndividualReviewValidator validator;
    
    @InitBinder
    public void init(WebDataBinder dataBinder) {
    	StringTrimmerEditor trimerEditor = new StringTrimmerEditor(true);
    	dataBinder.registerCustomEditor(String.class,trimerEditor);
    	dataBinder.addValidators(validator);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<IndividualReview> get(@PathVariable("id") Long individualReviewId){
    	IndividualReview individualReview = individualReviewService.findById(individualReviewId);
    	if(individualReview == null) {
    		throw new NotFoundException("IndividualReview not found");
    	}
    	return new ResponseEntity<>(individualReview, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody IndividualReview individualReview, 
    		BindingResult bindingResult){
    	if(bindingResult.hasErrors()) {
    		log.error("Error in adding IndividualReview {}, {}", individualReview, bindingResult );
    		throw new ValidationException("Error validating IndividualReview", ValidationUtils.getFieldErrors(bindingResult));
    	}
    	individualReviewService.save(individualReview);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long individualReviewId, 
    		@Valid @RequestBody IndividualReview individualReview, BindingResult bindingResult){
    	IndividualReview ir = individualReviewService.findById(individualReviewId);
    	if(ir == null) {
    		throw new NotFoundException("IndividualReview not found");
    	}
    	if(bindingResult.hasErrors()) {
    		log.error("Error validating IndividualReview {}, {}", individualReview, bindingResult);
    		throw new ValidationException("Error validating IndividualReview",ValidationUtils.getFieldErrors(bindingResult));
    	}
    	individualReview.setId(individualReviewId);
    	individualReviewService.save(individualReview);
    	return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/")
    public ResponseEntity<IndividualReviewListWrapper> individualReviews() {
    	IndividualReviewListWrapper individualReviews= new IndividualReviewListWrapper(individualReviewService.findAll());
    	return new ResponseEntity<>(individualReviews, HttpStatus.OK);
    }
}








































