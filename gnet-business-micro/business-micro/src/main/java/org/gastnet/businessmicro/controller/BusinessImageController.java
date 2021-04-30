package org.gastnet.businessmicro.controller;

import lombok.extern.slf4j.Slf4j;
import org.gastnet.businessmicro.entity.BusinessImage;
import org.gastnet.businessmicro.entity.Location;
import org.gastnet.businessmicro.exception.NotFoundException;
import org.gastnet.businessmicro.exception.ValidationException;
import org.gastnet.businessmicro.service.BusinessImageService;
import org.gastnet.businessmicro.service.LocationService;
import org.gastnet.businessmicro.utils.ValidationUtils;
import org.gastnet.businessmicro.validator.BusinessImageValidator;
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

@Slf4j
@RestController
public class BusinessImageController {

    @Autowired
    private BusinessImageService businessImageService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private BusinessImageValidator businessImageValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        StringTrimmerEditor trimEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimEditor);
        dataBinder.addValidators(businessImageValidator);
    }

    @GetMapping("/image/{imageId}")
    public ResponseEntity<BusinessImage> get(@PathVariable("imageId") Long imageId) {
        BusinessImage businessImage = businessImageService.findById(imageId);
        if (businessImage == null) {
            throw new NotFoundException("Business image not found");
        }
        return new ResponseEntity<>(businessImage, HttpStatus.OK);
    }

    @GetMapping("/location/{locationId}/image")
    public ResponseEntity<List<BusinessImage>> getByBusinessId(@PathVariable("locationId") Long locationId) {
        Location location = locationService.findById(locationId);
        if (location == null) {
            throw new NotFoundException("Location not found");
        }
        return new ResponseEntity<List<BusinessImage>>(
                businessImageService.findByLocation(location),
                HttpStatus.OK);
    }

    @PostMapping("/location/{locationId}/image")
    public ResponseEntity<?> add(@Valid @RequestBody BusinessImage businessImage,
                                 @PathVariable("locationId") Long locationId,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Errors in adding image {}, {}", businessImage, bindingResult);
            throw new ValidationException("Error validating image",
                    ValidationUtils.getFieldErrors(bindingResult));
        }
        Location location = locationService.findById(locationId);
        if (location == null) {
            throw new NotFoundException("Location not found");
        }
        businessImage.setLocation(location);
        businessImageService.save(businessImage);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/location/image/{imageId}")
    public ResponseEntity<?> update(@Valid @RequestBody BusinessImage businessImage,
                                    @PathVariable("imageId") Long imageId,
                                    BindingResult bindingResult) {
        BusinessImage existingBusinessImage = businessImageService.findById(imageId);
        if (existingBusinessImage == null) {
            throw new NotFoundException("Image not found");
        }
        if (bindingResult.hasErrors()) {
            log.error("Errors in updating image {}, {}", businessImage, bindingResult);
            throw new ValidationException("Error validating image",
                    ValidationUtils.getFieldErrors(bindingResult));
        }
        businessImage.setBusinessImageId(imageId); ;
        businessImageService.save(businessImage);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
