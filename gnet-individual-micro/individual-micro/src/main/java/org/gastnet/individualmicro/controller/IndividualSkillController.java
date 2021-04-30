package org.gastnet.individualmicro.controller;

import java.util.List;

import javax.validation.Valid;

import org.gastnet.individualmicro.entity.Individual;
import org.gastnet.individualmicro.entity.IndividualSkill;
import org.gastnet.individualmicro.exception.NotFoundException;
import org.gastnet.individualmicro.exception.ValidationException;
import org.gastnet.individualmicro.model.SkillSetWrapper;
import org.gastnet.individualmicro.service.IndividualSkillService;
import org.gastnet.individualmicro.utils.JSONRequestMapping;
import org.gastnet.individualmicro.utils.ValidationUtils;
import org.gastnet.individualmicro.validator.IndividualSkillValidator;
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
@JSONRequestMapping("/individual-skills")
public class IndividualSkillController {

	@Autowired
	private IndividualSkillService individualSkillService;
	
	@Autowired
	private IndividualSkillValidator individualSkillValidator;
	
	@InitBinder
	public void initBindir(WebDataBinder dataBinder) {
		StringTrimmerEditor trimEditor = new StringTrimmerEditor(true);	
		dataBinder.registerCustomEditor(String.class, trimEditor);
		dataBinder.addValidators(individualSkillValidator);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<IndividualSkill>> getAll(){
		return new ResponseEntity<List<IndividualSkill>>(individualSkillService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{individualSkillId}")
	public ResponseEntity<IndividualSkill> get(@PathVariable long individualSkillId){
		IndividualSkill individualSkill = individualSkillService.findById(individualSkillId);
		if(individualSkill == null) {
			throw new NotFoundException("IndividualSkill not found");
		}
		return new ResponseEntity<IndividualSkill>(individualSkill, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> save(@Valid@RequestBody IndividualSkill individualSkill, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			log.error("IndividualSkill not found");
			throw new ValidationException("Error validating IndividualSkill",ValidationUtils.getFieldErrors(bindingResult));
		}
		individualSkillService.save(individualSkill);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<?> update(@Valid@RequestBody IndividualSkill individualSkill, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			log.error("Error in updating IndividualSkill");
			throw new ValidationException("Error validating IndividualSkill",ValidationUtils.getFieldErrors(bindingResult));
		}
		individualSkillService.save(individualSkill);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{individualSkillId}")
	public ResponseEntity<?> delete(@PathVariable long individualSkillId){
		IndividualSkill individualSkill = individualSkillService.findById(individualSkillId);
		if (individualSkill == null) {
			log.error("Error in deleting IndividualSkill");
			throw new NotFoundException("IndividualSkill not found");
		}
		individualSkillService.delete(individualSkill);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/by-individual")
	public ResponseEntity<SkillSetWrapper> getByIndividual(@RequestBody Individual individual){
		SkillSetWrapper individualSkill = new SkillSetWrapper(individualSkillService.findByIndividual(individual));
		if(individualSkill.getSkills() == null) {
			throw new NotFoundException("IndividualSkill not found");
		}
		return new ResponseEntity<SkillSetWrapper>(individualSkill, HttpStatus.OK);
	}
}

