package org.gastnet.reviewmicro.controller;

import javax.validation.Valid;

import org.gastnet.reviewmicro.entity.ExpertiseReview;
import org.gastnet.reviewmicro.exception.NotFoundException;
import org.gastnet.reviewmicro.exception.ValidationException;
import org.gastnet.reviewmicro.model.ExpertiseReviewListWrapper;
import org.gastnet.reviewmicro.service.ExpertiseReviewService;
import org.gastnet.reviewmicro.utils.ValidationUtils;
import org.gastnet.reviewmicro.validator.ExpertiseReviewValidator;
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
public class ExpertiseReviewController {

	@Autowired
	private ExpertiseReviewService expertiseReviewService;

	@Autowired
	private ExpertiseReviewValidator validator;

	@InitBinder
	public void init(WebDataBinder dataBinder) {
		StringTrimmerEditor trimEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, trimEditor);
		dataBinder.addValidators(validator);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ExpertiseReview> get(@PathVariable("id") Long reviewId) {
		ExpertiseReview review = expertiseReviewService.findById(reviewId);
		if (review == null) {
			throw new NotFoundException("Review not found");
		}
		return new ResponseEntity<>(review, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody ExpertiseReview review, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			log.error("Errors in adding review {}, {}", review, bindingResult);
			throw new ValidationException("Error validating review", ValidationUtils.getFieldErrors(bindingResult));
		}
		expertiseReviewService.save(review);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long expertiseReviewId,
			@Valid @RequestBody ExpertiseReview expertiseReview, BindingResult bindingResult) {
		ExpertiseReview existingReview = expertiseReviewService.findById(expertiseReviewId);
		if (existingReview == null) {
			throw new NotFoundException("Review not found");
		}
		if (bindingResult.hasErrors()) {
			log.error("Errors in updating review {}, {}", expertiseReview, bindingResult);
			throw new ValidationException("Error validating review", ValidationUtils.getFieldErrors(bindingResult));
		}
		expertiseReview.setBusinessId(expertiseReviewId);
		expertiseReviewService.save(expertiseReview);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<ExpertiseReviewListWrapper> expertiseReviews() {
		ExpertiseReviewListWrapper expertiseReviews= new ExpertiseReviewListWrapper(
				expertiseReviewService.findAll());
		return new ResponseEntity<>(expertiseReviews, HttpStatus.OK);
	}

}
