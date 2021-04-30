package org.gastnet.individualmicro.controller;

import java.util.List;

import javax.validation.Valid;

import org.gastnet.individualmicro.entity.Individual;
import org.gastnet.individualmicro.entity.ProfessionalData;
import org.gastnet.individualmicro.exception.NotFoundException;
import org.gastnet.individualmicro.exception.ValidationException;
import org.gastnet.individualmicro.model.DataSetWrapper;
import org.gastnet.individualmicro.service.ProfessionalDataService;
import org.gastnet.individualmicro.utils.JSONRequestMapping;
import org.gastnet.individualmicro.utils.ValidationUtils;
import org.gastnet.individualmicro.validator.ProfessionalDataValidator;
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
@JSONRequestMapping("/professional-data")
public class ProfessionalDataController {

	@Autowired
	private ProfessionalDataService professionalDataService;
	
	@Autowired
	private ProfessionalDataValidator professionalDataValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor trimEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, trimEditor);
		dataBinder.addValidators(professionalDataValidator);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ProfessionalData>> getAll(){
		return new ResponseEntity<List<ProfessionalData>> (professionalDataService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{professionalDataId}")
	public ResponseEntity<ProfessionalData> get(@PathVariable long professionalDataId){
		ProfessionalData professionalData = professionalDataService.findById(professionalDataId);
		if(professionalData == null) {
			throw new NotFoundException("ProfessionalData not found");
		}
		return new ResponseEntity<ProfessionalData>(professionalData,HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> save(@Valid@RequestBody ProfessionalData professionalData, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			log.error("Error in saving ProfessionalData");
			throw new ValidationException("Error validating ProfessionalData", ValidationUtils.getFieldErrors(bindingResult));
		}
		professionalDataService.save(professionalData);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<?> update(@Valid@RequestBody ProfessionalData professionalData, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			log.error("Error in updating ProfessionalData");
			throw new ValidationException("Error validating ProfessionalData", ValidationUtils.getFieldErrors(bindingResult));
		}
		professionalDataService.save(professionalData);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{professionalDataId}")
	public ResponseEntity<?> delete(@PathVariable long professionalDataId){
		ProfessionalData professionalData = professionalDataService.findById(professionalDataId);
		if(professionalData == null) {
			throw new NotFoundException("ProfessionalData not found");
		}
		professionalDataService.delete(professionalData);
		return new ResponseEntity<ProfessionalData>(professionalData,HttpStatus.OK);
	}
	
	@PostMapping("/by-individual")
	public ResponseEntity<DataSetWrapper> getByIndividual(@RequestBody Individual individual){
		DataSetWrapper professionalData = new DataSetWrapper(professionalDataService.findByIndividual(individual));
		if(professionalData.getData() == null) {
			throw new NotFoundException("ProfessionalData not found");
		}
		return new ResponseEntity<DataSetWrapper>(professionalData,HttpStatus.OK);
	}
}
