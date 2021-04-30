package org.gastnet.clientmicro.serviceImpl;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.gastnet.clientmicro.dto.BusinessProfileDTO;
import org.gastnet.clientmicro.enumeration.URL;
import org.gastnet.clientmicro.service.BusinessService;
import org.gastnet.clientmicro.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BusinessServiceImpl implements BusinessService{

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public BusinessProfileDTO getBusinessProfileData(long userId,HttpServletRequest request) {
		try {
			ResponseEntity<BusinessProfileDTO>  response = restTemplate.exchange(RequestUtils.getAuthorizedGetRequest(request, URI.create(URL.BUSINESS.getValue() + "profile/"+userId)), BusinessProfileDTO.class);
			if(response.getStatusCode().equals(HttpStatus.OK)) {
				return response.getBody();
			}
			return null;
		}catch(Exception e) {
			log.error(e.getMessage());
			return null;
		}
		 
	}

}
