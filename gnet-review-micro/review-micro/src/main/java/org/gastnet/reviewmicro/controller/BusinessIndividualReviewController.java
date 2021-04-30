package org.gastnet.reviewmicro.controller;

import javax.validation.Valid;

import org.gastnet.reviewmicro.entity.BusinessIndividualReview;
import org.gastnet.reviewmicro.exception.NotFoundException;
import org.gastnet.reviewmicro.exception.ValidationException;
import org.gastnet.reviewmicro.model.BusinessIndividualReviewWrapper;
import org.gastnet.reviewmicro.service.BusinessIndividualReviewService;
import org.gastnet.reviewmicro.utils.ValidationUtils;
import org.gastnet.reviewmicro.validator.BusinessIndividualReviewValidator;
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
public class BusinessIndividualReviewController {

	@Autowired
	private BusinessIndividualReviewService businessIndividualReviewService;

	@Autowired
	private BusinessIndividualReviewValidator businessIndividualReviewValidator;

	@InitBinder
	public void init(WebDataBinder dataBinder) {
		StringTrimmerEditor trimEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, trimEditor);
		dataBinder.addValidators(businessIndividualReviewValidator);
	}

	@GetMapping("{id}")
	public ResponseEntity<BusinessIndividualReview> get(@PathVariable("id") Long businessIndividualReviewId) {
		BusinessIndividualReview businessIndividualReview = businessIndividualReviewService
				.findById(businessIndividualReviewId);
		if (businessIndividualReview == null) {
			throw new NotFoundException("BusinessIndividualReview not found");
		}
		return new ResponseEntity<>(businessIndividualReview, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody BusinessIndividualReview businessIndividualReview,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			log.error("Errors in adding BusinessIndividualReview {}, {}", businessIndividualReview, bindingResult);
			throw new ValidationException("Error validating businessIndividualReview",
					ValidationUtils.getFieldErrors(bindingResult));
		}
		businessIndividualReviewService.save(businessIndividualReview);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long businessIndividualReviewId,
			@Valid @RequestBody BusinessIndividualReview businessIndividualReview, BindingResult bindingResult) {
		BusinessIndividualReview bir = businessIndividualReviewService.findById(businessIndividualReviewId);
		if (bir == null) {
			throw new NotFoundException("BusinessIndividualReview not found");
		}
		if (bindingResult.hasErrors()) {
			log.error("Errors in updating business {}, {}", businessIndividualReview, bindingResult);
			throw new ValidationException("Error validating BusinessIndividualReview",
					ValidationUtils.getFieldErrors(bindingResult));
		}
		businessIndividualReview.setBusinessIndividualReviewId(businessIndividualReviewId);
		businessIndividualReviewService.save(businessIndividualReview);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping 
	public ResponseEntity<BusinessIndividualReviewWrapper> businessIndividualReviews(){
		BusinessIndividualReviewWrapper reviews = new BusinessIndividualReviewWrapper(businessIndividualReviewService.findAll());
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}

}
