package org.gastnet.gatewayservice.service;

import org.gastnet.gatewayservice.dto.BusinessUserDTO;
import org.gastnet.gatewayservice.dto.IndividualUserDTO;
import org.gastnet.gatewayservice.enumeration.URL;
import org.gastnet.gatewayservice.model.ValidationErrors;
import org.gastnet.gatewayservice.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/register")
public class UserRegistrationService {

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/individual")
	public ResponseEntity<?> processIndividualSagaInsertation(@RequestBody IndividualUserDTO individualUserDTO) {
		
		try {
			ResponseEntity<ValidationErrors> response = doPost(individualUserDTO.getIndividual(), URL.INDIVIDUAL, "validate");
			if (response.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
				ValidationErrors errors = response.getBody();
				response = doPost(individualUserDTO.getUser(), URL.USER,"validate");
				if (response.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
					errors = this.combineErrors(errors, response);
				}
				return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
			}
			response = doPost(individualUserDTO, URL.USER, "individual-user");
			if(response.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
				return new ResponseEntity<>(response.getBody(), HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/business")
	public ResponseEntity<?> processBusinessSagaInsertation(@RequestBody BusinessUserDTO businessUserDTO){
		try {
			ResponseEntity<ValidationErrors> response = doPost(businessUserDTO.getBusiness(),URL.BUSINESS,"validate");
			if (response.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
				ValidationErrors errors = response.getBody();
				response = doPost(businessUserDTO.getUser(), URL.USER,"validate");
				if (response.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
					errors = this.combineErrors(errors, response);
				}
				return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
			}
			response = doPost(businessUserDTO, URL.USER, "business-user");
			if(response.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
				return new ResponseEntity<>(response.getBody(), HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private ValidationErrors combineErrors(ValidationErrors errors, ResponseEntity<ValidationErrors> response) {
		response.getBody().getErrors().entrySet().stream()
				.forEach(error -> errors.getErrors().put(error.getKey(), error.getValue()));
		return errors;
	}

	private <T> ResponseEntity<ValidationErrors> doPost(T parameter, URL url, String suffix) {
		return restTemplate.exchange(RequestUtils.getRequestEntity(parameter, url, suffix), ValidationErrors.class);
	}

}
