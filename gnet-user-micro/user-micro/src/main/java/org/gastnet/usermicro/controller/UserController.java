package org.gastnet.usermicro.controller;

import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.gastnet.usermicro.command.service.UserCommandService;
import org.gastnet.usermicro.dto.BusinessUserDTO;
import org.gastnet.usermicro.dto.IndividualUserDTO;
import org.gastnet.usermicro.entity.User;
import org.gastnet.usermicro.exception.ValidationException;
import org.gastnet.usermicro.service.impl.UserService;
import org.gastnet.usermicro.utils.ValidationUtils;
import org.gastnet.usermicro.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserCommandService userCommandService;
	
	@Autowired
	private UserValidator userValidator;

	@GetMapping("/user/{email}")
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
		User user = userService.getUserByEmail(email);
		System.out.println(user.toString());
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/id/{userId}")
	public  ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
		User user = userService.findById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public void add(@RequestBody User user) {
		user.setCreationDate(new Date());
		user.setPassword(RandomStringUtils.random(36));
		userService.save(user);
	}
	
	@PostMapping("/individual-user")
	public ResponseEntity<?> addIndividualUser(@RequestBody IndividualUserDTO individualUser, BindingResult bindingResult){
		userValidator.validateDTOUser(individualUser.getUser(), bindingResult,"user.");
		if(bindingResult.hasErrors()) {
			log.error("Error in validating BusinessUser {}, {}",individualUser ,bindingResult);
			throw new ValidationException("Error validating user" ,ValidationUtils.getFieldErrors(bindingResult));
		}
		try {
			userCommandService.saveIndividualUser(individualUser);
		}catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/business-user")
	public ResponseEntity<?> addBusinessUser(@RequestBody BusinessUserDTO businessUser, BindingResult bindingResult){
		userValidator.validateDTOUser(businessUser.getUser(), bindingResult,"user.");
		if(bindingResult.hasErrors()) {
			log.error("Error in validating BusinessUser {}, {}",businessUser ,bindingResult);
			throw new ValidationException("Error validating user" ,ValidationUtils.getFieldErrors(bindingResult));
		}
		try {
			userCommandService.saveBusinessUser(businessUser);
		}catch (Exception e) {
			log.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody User user, BindingResult bindingResult){
		userValidator.validate(user, bindingResult);
		if(bindingResult.hasErrors()) {
			log.error("Error in validating user {}, {}",user ,bindingResult);
			throw new ValidationException("Error validating user" ,ValidationUtils.getFieldErrors(bindingResult, "user."));
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
