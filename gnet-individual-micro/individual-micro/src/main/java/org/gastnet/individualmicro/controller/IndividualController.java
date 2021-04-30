package org.gastnet.individualmicro.controller;

import javax.validation.Valid;

import org.gastnet.individualmicro.entity.Individual;
import org.gastnet.individualmicro.exception.NotFoundException;
import org.gastnet.individualmicro.exception.ValidationException;
import org.gastnet.individualmicro.model.IndividualListWrapper;
import org.gastnet.individualmicro.model.IndividualModel;
import org.gastnet.individualmicro.model.IndividualUser;
import org.gastnet.individualmicro.service.ExperienceService;
import org.gastnet.individualmicro.service.IndividualService;
import org.gastnet.individualmicro.service.IndividualSkillService;
import org.gastnet.individualmicro.service.ProfessionalDataService;
import org.gastnet.individualmicro.utils.JSONRequestMapping;
import org.gastnet.individualmicro.utils.ValidationUtils;
import org.gastnet.individualmicro.validator.IndividualValidator;
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
@JSONRequestMapping("/individuals")
public class IndividualController {

	@Autowired
	private IndividualService individualService;
	
	@Autowired
	private ExperienceService expereinceService;
	
	@Autowired
	private IndividualSkillService skillService;
	
	@Autowired
	private ProfessionalDataService dataService;

	@Autowired
	private IndividualValidator individualValidator;

	@InitBinder
	public void initBindir(WebDataBinder dataBinder) {
		StringTrimmerEditor trimEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, trimEditor);
		dataBinder.addValidators(individualValidator);
	}

	@GetMapping("/")
	public ResponseEntity<IndividualListWrapper> getAll() {
		IndividualListWrapper individuals = new IndividualListWrapper(individualService.findAll());
		return new ResponseEntity<>(individuals, HttpStatus.OK);
	}

	@GetMapping("/{individualId}")
	public ResponseEntity<IndividualModel> get(@PathVariable("individualId") long individualId) {
		Individual individual = individualService.findById(individualId);
		if (individual == null) {
			log.error("Error in geting individual");
			throw new NotFoundException("Individual not found");
		}
		IndividualModel individualModel = new IndividualUser.Builder()
				.individualId(individual.getIndividualId())
				.name(individual.getName())
				.lastName(individual.getLastName())
				.birthDate(individual.getBirthDate())
				.gender(individual.getGender())
				.city(individual.getCity())
				.state(individual.getState())
				.phoneNumber(individual.getPhoneNumber())
				.imageUrl(individual.getImageUrl())
				.individualType(individual.getIndividualType())
				.experiences(expereinceService.findByIndividual(individual))
				.individualSkills(skillService.findByIndividual(individual))
				.professionalData(dataService.findByIndividual(individual))
				.build();
		
		return new ResponseEntity<>(individualModel, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<?> save(@Valid@RequestBody Individual individual,BindingResult bindingResult) throws Exception{
		if(bindingResult.hasErrors()) {
			log.error("Errors in saving individual {}, {}", individual, bindingResult);
			throw new ValidationException("Error validating individual",ValidationUtils.getFieldErrors(bindingResult,"individual."));	
		}
		individualService.save(individual);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<?> ValidateUser(@Valid@RequestBody Individual individual,BindingResult bindingResult) throws Exception{
		if(bindingResult.hasErrors()) {
			log.error("Errors in validating individual {}, {}", individual, bindingResult);
			throw new ValidationException("Error validating individual",ValidationUtils.getFieldErrors(bindingResult,"individual."));	
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/")
	public ResponseEntity<?> update(@Valid @RequestBody Individual individual, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			log.error("Error in updating Individual");
			throw new ValidationException("Error validating individual", ValidationUtils.getFieldErrors(bindingResult));
		}
		individualService.save(individual);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/{individualId}")
	public ResponseEntity<?> delete(@PathVariable long individualId) {
		Individual individual = individualService.findById(individualId);
		if(individual == null) {
			log.error("Error in deleting individual: {}",individual);
			throw new NotFoundException("Individual not found");
		}
		individualService.delete(individual);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/byUserId/{userId}")
	public ResponseEntity<Individual> getIndividualByUserId(@PathVariable("userId") long userId) {
		Individual individual = individualService.findByUserId(userId);
		if (individual == null) {
			log.error("Non Individual whith that email exists");
			throw new NotFoundException("Individual not found");
		}
		return new ResponseEntity<>(individual, HttpStatus.OK);
	}
}
