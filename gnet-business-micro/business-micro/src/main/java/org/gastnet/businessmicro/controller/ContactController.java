package org.gastnet.businessmicro.controller;

import java.util.Set;

import javax.validation.Valid;

import org.gastnet.businessmicro.entity.Business;
import org.gastnet.businessmicro.entity.Contact;
import org.gastnet.businessmicro.exception.NotFoundException;
import org.gastnet.businessmicro.exception.ValidationException;
import org.gastnet.businessmicro.service.BusinessService;
import org.gastnet.businessmicro.service.ContactService;
import org.gastnet.businessmicro.utils.ValidationUtils;
import org.gastnet.businessmicro.validator.ContactValidator;
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
public class ContactController {
    @Autowired
    private ContactService contactService;
    @Autowired
    private BusinessService businessService;
    @Autowired
    private ContactValidator contactValidator;

    @InitBinder
    public void init(WebDataBinder dataBinder) {
        StringTrimmerEditor trimEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimEditor);
        dataBinder.addValidators(contactValidator);
    }

    @GetMapping("/contact/{contactId}")
    public ResponseEntity<Contact> get(@PathVariable("contactId") Long contactId) {
        Contact contact = contactService.findById(contactId);
        if (contact == null) {
            throw new NotFoundException("Contact not found");
        }
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @GetMapping("/{businessId}/contact")
    public ResponseEntity<Set<Contact>> getByBusinessId(@PathVariable("businessId") Long businessId) {
        Business business = businessService.findById(businessId);
        if (business == null) {
            throw new NotFoundException("Business not found");
        }
        return new ResponseEntity<Set<Contact>>(
                contactService.findByBusiness(business),
                HttpStatus.OK);
    }

    @PostMapping("/{businessId}/contact")
    public ResponseEntity<?> add(@Valid @RequestBody Contact contact,
                                 @PathVariable("businessId") Long businessId,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("Errors in adding contact {}, {}", contact, bindingResult);
            throw new ValidationException("Error validating contact",
                    ValidationUtils.getFieldErrors(bindingResult));
        }
        Business business = businessService.findById(businessId);
        if (business == null) {
            throw new NotFoundException("Business not found");
        }
        contact.setBusiness(business);
        contactService.save(contact);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/contact/{contactId}")
    public ResponseEntity<?> update(@Valid @RequestBody Contact contact,
                                    @PathVariable("contactId") Long contactId,
                                    BindingResult bindingResult) {
        Contact existingContact = contactService.findById(contactId);
        if (existingContact == null) {
            throw new NotFoundException("Contact not found");
        }
        if (bindingResult.hasErrors()) {
            log.error("Errors in updating contact {}, {}", contact, bindingResult);
            throw new ValidationException("Error validating contact",
                    ValidationUtils.getFieldErrors(bindingResult));
        }
        contact.setContactId(contactId); ;
        contactService.save(contact);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
