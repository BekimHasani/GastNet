package org.gastnet.clientmicro.serviceImpl;

import org.gastnet.clientmicro.dto.BusinessUserDTO;
import org.gastnet.clientmicro.dto.IndividualUserDTO;
import org.gastnet.clientmicro.enumeration.ContactType;
import org.gastnet.clientmicro.enumeration.URL;
import org.gastnet.clientmicro.model.Business;
import org.gastnet.clientmicro.model.Contact;
import org.gastnet.clientmicro.model.ValidationErrors;
import org.gastnet.clientmicro.service.SignUpService;
import org.gastnet.clientmicro.util.RequestUtils;
import org.gastnet.clientmicro.util.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void individualSignUp(IndividualUserDTO individualUserDTO, BindingResult bindingResult) {
		try {
			ResponseEntity<ValidationErrors> individualResponse = restTemplate.exchange(
					RequestUtils.getRequestEntity(individualUserDTO, URL.REGISTER, "individual"),ValidationErrors.class);
			if (individualResponse.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
				ValidationUtils.addValidationErrors(individualResponse, bindingResult);
			}
		} catch (RestClientException e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public void businessSignUp(BusinessUserDTO businessUserDTO, BindingResult bindingResult) {
		try {
			businessUserDTO = this.prepareBusinessForRestCall(businessUserDTO);
			ResponseEntity<ValidationErrors> businessResponse = restTemplate.exchange(
					RequestUtils.getRequestEntity(businessUserDTO, URL.REGISTER, "business"), ValidationErrors.class);
			if (businessResponse.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
				ValidationUtils.addValidationErrors(businessResponse, bindingResult);
			}
		} catch (RestClientException e) {
			log.error(e.getMessage());
		}

	}

	

	private BusinessUserDTO prepareBusinessForRestCall(BusinessUserDTO businessUserDTO) {
		Business business = businessUserDTO.getBusiness();
		Contact emailContact = businessUserDTO.getEmailContact();
		Contact phoneContact = businessUserDTO.getPhoneContact();
		emailContact.setContactType(ContactType.EMAIL);
		phoneContact.setContactType(ContactType.PHONE);
		businessUserDTO.getUser().setEmail(businessUserDTO.getEmailContact().getContactValue());
		business.getContacts().add(emailContact);
		business.getContacts().add(phoneContact);
		business.getLocations().add(businessUserDTO.getLocation());
		return new BusinessUserDTO(business, businessUserDTO.getUser());
	}

}
