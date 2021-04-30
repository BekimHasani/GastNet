package org.gastnet.individualmicro.controller;

import java.util.List;

import javax.validation.Valid;

import org.gastnet.individualmicro.entity.Skill;
import org.gastnet.individualmicro.exception.NotFoundException;
import org.gastnet.individualmicro.exception.ValidationException;
import org.gastnet.individualmicro.service.SkillService;
import org.gastnet.individualmicro.utils.JSONRequestMapping;
import org.gastnet.individualmicro.utils.ValidationUtils;
import org.gastnet.individualmicro.validator.SkillValidator;
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
@JSONRequestMapping("/skills")
public class SkillController {

	@Autowired
	private SkillService skillService;
	
	@Autowired
	private SkillValidator skillValidator;
	
	@InitBinder
	public void initBindir(WebDataBinder dataBinder) {
		StringTrimmerEditor trimEditor = new StringTrimmerEditor(true);	
		dataBinder.registerCustomEditor(String.class, trimEditor);
		dataBinder.addValidators(skillValidator);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Skill>> getAll(){
		return new ResponseEntity<List<Skill>>(skillService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{skillId}")
	public ResponseEntity<Skill> get(@PathVariable long skillId){
		Skill skill = skillService.findById(skillId);
		if(skill == null) {
			throw new NotFoundException("Skill not found");
		}
		return new ResponseEntity<Skill>(skill, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> save(@Valid@RequestBody Skill skill, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			log.error("Skill not found");
			throw new ValidationException("Error validating Skill",ValidationUtils.getFieldErrors(bindingResult));
		}
		skillService.save(skill);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<?> update(@Valid@RequestBody Skill skill, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			log.error("Error in updating Skill");
			throw new ValidationException("Error validating Skill",ValidationUtils.getFieldErrors(bindingResult));
		}
		skillService.save(skill);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{skillId}")
	public ResponseEntity<?> delete(@PathVariable long skillId){
		Skill skill = skillService.findById(skillId);
		if (skill == null) {
			log.error("Error in deleting Skill");
			throw new NotFoundException("Skill not found");
		}
		skillService.delete(skill);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
