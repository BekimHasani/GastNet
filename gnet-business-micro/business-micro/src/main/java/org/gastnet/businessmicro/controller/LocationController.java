package org.gastnet.businessmicro.controller;

import lombok.extern.slf4j.Slf4j;
import org.gastnet.businessmicro.entity.Business;
import org.gastnet.businessmicro.entity.Location;
import org.gastnet.businessmicro.exception.NotFoundException;
import org.gastnet.businessmicro.exception.ValidationException;
import org.gastnet.businessmicro.service.BusinessService;
import org.gastnet.businessmicro.service.LocationService;
import org.gastnet.businessmicro.utils.ValidationUtils;
import org.gastnet.businessmicro.validator.LocationValidator;
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

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Slf4j
@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;
    @Autowired
    private BusinessService businessService;
    @Autowired
    private LocationValidator locationValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        StringTrimmerEditor trimEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimEditor);
        dataBinder.addValidators(locationValidator);
    }

    @GetMapping("/location/{locationId}")
    public ResponseEntity<Location> get(@PathVariable("locationId") Long locationId) {
        Location location = locationService.findById(locationId);
        if (location == null) {
            throw new NotFoundException("Location not found");
        }
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @GetMapping("/{businessId}/location")
    public ResponseEntity<Set<Location>> getByBusinessId(@PathVariable("businessId") Long businessId) {
        Business business = businessService.findById(businessId);
        if (business == null) {
            throw new NotFoundException("Business not found");
        }
        return new ResponseEntity<Set<Location>>(
                locationService.findByBusiness(business),
                HttpStatus.OK);
    }

    @PostMapping("/{businessId}/location")
    public ResponseEntity<?> add(@Valid @RequestBody Location location,
                                 @PathVariable("businessId") Long businessId,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Errors in adding location {}, {}", location, bindingResult);
            throw new ValidationException("Error validating location",
                    ValidationUtils.getFieldErrors(bindingResult));
        }
        Business business = businessService.findById(businessId);
        if (business == null) {
            throw new NotFoundException("Business not found");
        }
        location.setBusiness(business);
        locationService.save(location);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/location/{locationId}")
    public ResponseEntity<?> update(@Valid @RequestBody Location location,
                                    @PathVariable("locationId") Long locationId,
                                    BindingResult bindingResult) {
        Location existingLocation = locationService.findById(locationId);
        if (existingLocation == null) {
            throw new NotFoundException("Location not found");
        }
        if (bindingResult.hasErrors()) {
            log.error("Errors in updating location {}, {}", location, bindingResult);
            throw new ValidationException("Error validating location",
                    ValidationUtils.getFieldErrors(bindingResult));
        }
        location.setLocationId(locationId); ;
        locationService.save(location);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
