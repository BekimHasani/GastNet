package org.gastnet.businessmicro.controller;

import javax.validation.Valid;

import org.gastnet.businessmicro.dto.BusinessProfileDTO;
import org.gastnet.businessmicro.entity.Business;
import org.gastnet.businessmicro.exception.NotFoundException;
import org.gastnet.businessmicro.exception.ValidationException;
import org.gastnet.businessmicro.model.BusinessListWrapper;
import org.gastnet.businessmicro.service.BusinessService;
import org.gastnet.businessmicro.service.ContactService;
import org.gastnet.businessmicro.service.LocationService;
import org.gastnet.businessmicro.utils.ValidationUtils;
import org.gastnet.businessmicro.validator.BusinessValidator;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/businesses")
public class BusinessController {

    @Autowired
    private BusinessService businessService;
    @Autowired
    private BusinessValidator businessValidator;
    

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        StringTrimmerEditor trimEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimEditor);
        dataBinder.addValidators(businessValidator);
    }

    @GetMapping("/{businessId}")
    public ResponseEntity<Business> get(@PathVariable("businessId") Long businessId) {
        Business business = businessService.findById(businessId);
        if (business == null) {
            throw new NotFoundException("Business not found");
        }
        return new ResponseEntity<>(business, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> add(@Valid @RequestBody Business business, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Errors in adding business {}, {}", business, bindingResult);
            throw new ValidationException("Error validating business",
                    ValidationUtils.getFieldErrors(bindingResult));
        }
        businessService.save(business);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{businessId}")
    public ResponseEntity<?> update(@PathVariable("businessId") Long businessId,
            @Valid @RequestBody Business business, BindingResult bindingResult) {
        Business existingBusiness = businessService.findById(businessId);
        if (existingBusiness == null) {
            throw new NotFoundException("Business not found");
        }
        if (bindingResult.hasErrors()) {
            log.error("Errors in updating business {}, {}", business, bindingResult);
            throw new ValidationException("Error validating business",
                    ValidationUtils.getFieldErrors(bindingResult));
        }
        business.setBusinessId(businessId);
        businessService.save(business);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PostMapping("/validate")
	public ResponseEntity<?> validateUser(@Valid@RequestBody Business business, BindingResult bindingResult){
		if(bindingResult.hasErrors()) {
			log.error("Errors in validating business {}, {}", business, bindingResult);
			throw new ValidationException("Error validating user" ,ValidationUtils.getFieldErrors(bindingResult, "business."));
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
    
    
    @GetMapping("/")
    public ResponseEntity<BusinessListWrapper> businesses() {
    	BusinessListWrapper businesses = new BusinessListWrapper(businessService.findAll());
    	return new ResponseEntity<>(businesses, HttpStatus.OK);
    }
    
    @GetMapping("/profile/{userId}")
    public ResponseEntity<BusinessProfileDTO> getBusinessProfileData(@PathVariable long userId){
    	Business business = businessService.getProfileData(userId); 
		BusinessProfileDTO profile = BusinessProfileDTO.builder().business(business).locations(business.getLocations())
				.contacts(business.getContacts()).expertises(business.getBusinessExpertise()).build();
    	return ResponseEntity.ok().body(profile);
    }
}
