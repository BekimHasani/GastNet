package org.gastnet.reviewmicro.controller;



import javax.validation.Valid;

import org.gastnet.reviewmicro.entity.BusinessReview;
import org.gastnet.reviewmicro.exception.NotFoundException;
import org.gastnet.reviewmicro.exception.ValidationException;
import org.gastnet.reviewmicro.model.BusinessReviewListWrapper;
import org.gastnet.reviewmicro.service.BusinessReviewService;
import org.gastnet.reviewmicro.utils.ValidationUtils;
import org.gastnet.reviewmicro.validator.BusinessReviewValidator;
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
public class BusinessReviewController {

    @Autowired
    private BusinessReviewService businessReviewService;
    
    @Autowired 
    private BusinessReviewValidator validator;
    
    @InitBinder
    public void init(WebDataBinder dataBinder) {
    	StringTrimmerEditor trimEditor = new StringTrimmerEditor(true);
    	dataBinder.registerCustomEditor(String.class, trimEditor);
    	dataBinder.addValidators(validator);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<BusinessReview> get(@PathVariable("id") Long businessReviewId){
    	BusinessReview businessReview = businessReviewService.findById(businessReviewId);
    	if(businessReview == null) {
    		throw new NotFoundException("BusinessReview not found");
    	}
    	return new ResponseEntity<>(businessReview, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody BusinessReview businessReview,
    		BindingResult bindingResult){
    	if(bindingResult.hasErrors()) {
    		log.error("Errors in adding BusinessReview {}, {}", businessReview, bindingResult);
    		throw new ValidationException("Error validating BusinessReview", ValidationUtils.getFieldErrors(bindingResult));
    	}
    	businessReviewService.save(businessReview);
    	return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long businessReviewId, 
    		@Valid @RequestBody BusinessReview businessReview, BindingResult bindingResult ){
    	BusinessReview br = businessReviewService.findById(businessReviewId);
    	if(br == null) {
    		throw new NotFoundException("BusinessReview not found");
    	}
    	if(bindingResult.hasErrors()) {
    		log.error("Errors in adding BusinessReview {}, {}", businessReview, bindingResult);
    		throw new ValidationException("Error validating BusinessReview ", ValidationUtils.getFieldErrors(bindingResult));
    	}
    	businessReview.setId(businessReviewId);
    	businessReviewService.save(businessReview);
    	return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<BusinessReviewListWrapper> businessReviews() {
    	BusinessReviewListWrapper businessReviews = new BusinessReviewListWrapper(businessReviewService.findAll());
    	return new ResponseEntity<>(businessReviews, HttpStatus.OK);
    }

}














































