package org.gastnet.usermicro.validator;

import org.gastnet.usermicro.entity.User;
import org.gastnet.usermicro.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator{

	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(User.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		this.validateUser(target,errors,"");
		
	}
	
	public void validateDTOUser(Object target,Errors errors, String prefix) {
		this.validateUser(target,errors,prefix);
	}
	
	private void validateUser(Object target,Errors errors, String prefix) {
		if(prefix == null) {
			prefix = "";
		}
		User user = (User)target;
		String email = user.getEmail();
		String password = user.getPassword();
		
		if(email == null || email.trim().isEmpty()) {
			errors.rejectValue(prefix+"email", "Email cannot be empty");
		}else if(email.matches("^[A-Za-z0-9._%+-]{1,64}@gmail.com")) {
			if(userService.getUserByEmail(email.trim()) != null) {
				errors.rejectValue(prefix+"email", "Account with this email already exists");
			}
		}else {
			errors.rejectValue(prefix+"email", "Invalid email format detected(must be gmail)");
		}
		
		if(password == null || password.trim().isEmpty()) {
			errors.rejectValue(prefix+"password", "Please provide a password");
		}else if (!password.matches(".*[0-9].*")) {
			errors.rejectValue(prefix+"password", "Password must contain at least one number");
		}else if (!password.matches(".*[a-z].*")) {
			errors.rejectValue(prefix+"password", "Password must contain at least one lowercase character");
		}else if (!password.matches(".*[A-Z].*")) {
			errors.rejectValue(prefix+"password", "Password must contain at least one uppercase character");
		}else if (!password.matches(".*[@#$%^&.,!].*")) {
			errors.rejectValue(prefix+"password", "Password must contain at least one specialCharacter [@#$%^&.,!]");
		}else if (password.matches(".*\\s.*")) {
			errors.rejectValue(prefix+"password", "Password cannot contain white spaces");
		}else if (!password.matches(".{8,20}")) {
				errors.rejectValue(prefix+"password", "Password must be on range of 8-20 characters");
		}else if(!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&.,!])(?=\\S+$).{8,20}$")) {
			errors.rejectValue(prefix+"password", "Invalid password format. Allowed only word character,number and @#$%^&.,! characters");
		}
	}

}
