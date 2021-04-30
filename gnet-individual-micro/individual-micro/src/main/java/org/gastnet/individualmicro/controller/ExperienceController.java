package org.gastnet.individualmicro.controller;

import java.util.List;

import javax.validation.Valid;

import org.gastnet.individualmicro.entity.Experience;
import org.gastnet.individualmicro.entity.Individual;
import org.gastnet.individualmicro.exception.NotFoundException;
import org.gastnet.individualmicro.exception.ValidationException;
import org.gastnet.individualmicro.model.ExperienceSetWrapper;
import org.gastnet.individualmicro.service.ExperienceService;
import org.gastnet.individualmicro.utils.JSONRequestMapping;
import org.gastnet.individualmicro.utils.ValidationUtils;
import org.gastnet.individualmicro.validator.ExperienceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@JSONRequestMapping("/experiences")
public class ExperienceController {

	@Autowired
	private ExperienceService experienceService;

	
	@Autowired 
	private ExperienceValidator experienceValidator;
	

	@InitBinder
	public void initBindir(WebDataBinder dataBinder) {
		StringTrimmerEditor trimEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, trimEditor);
		dataBinder.addValidators(experienceValidator);
	}

	@GetMapping("/")
	public ResponseEntity<List<Experience>> getAll() {
		return new ResponseEntity<List<Experience>>(experienceService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{experienceId}")
	public ResponseEntity<Experience> get(@PathVariable long experienceId) {
		Experience experience = experienceService.findById(experienceId);
		if (experience == null) {
			throw new NotFoundException("Experience not found");
		}
		return new ResponseEntity<Experience>(experience, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<?> save(@Valid@RequestBody Experience experience, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			log.error("Experience not found");
			throw new ValidationException("Error validating Experience", ValidationUtils.getFieldErrors(bindingResult));
		}
		experienceService.save(experience);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<?> update(@Valid @RequestBody Experience experience, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			log.error("Error in updating Experience");
			throw new ValidationException("Error validating Experience", ValidationUtils.getFieldErrors(bindingResult));
		}
		experienceService.save(experience);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{experienceId}")
	public ResponseEntity<?> delete(@PathVariable long experienceId) {
		Experience experience = experienceService.findById(experienceId);
		if (experience == null) {
			log.error("Error in deleting Experience");
			throw new NotFoundException("Experience not found");
		}
		experienceService.delete(experience);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/by-individual")
	public ResponseEntity<ExperienceSetWrapper> getByIndividual(@RequestBody Individual individual) {
		ExperienceSetWrapper experience = new ExperienceSetWrapper(experienceService.findByIndividual(individual));
		if (experience.getExperiences() == null) {
			throw new NotFoundException("Experience not found");
		}
		return new ResponseEntity<ExperienceSetWrapper>(experience, HttpStatus.OK);
	}
}
