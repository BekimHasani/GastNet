package org.gastnet.clientmicro.serviceImpl;

import javax.servlet.http.HttpServletRequest;

import org.gastnet.clientmicro.enumeration.URL;
import org.gastnet.clientmicro.model.Experience;
import org.gastnet.clientmicro.model.Individual;
import org.gastnet.clientmicro.model.IndividualSkill;
import org.gastnet.clientmicro.model.ProfessionalData;
import org.gastnet.clientmicro.service.IndividualService;
import org.gastnet.clientmicro.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IndividualServiceImpl implements IndividualService{

	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Individual getIndividual(HttpServletRequest request, Long individualId) {
		log.info("Retrviving a specific individual user bu userId form individual database table");
		ResponseEntity<Individual> response = restTemplate.exchange(RequestUtils.getAuthorizedGetRequest(request, 
				RequestUtils.getURI(URL.INDIVIDUAL, ""+individualId)), Individual.class);
		return response.getBody() ;
	}
	
	@Override
	public Individual getIndividualByUserId(HttpServletRequest request, Long userId) {
		log.info("Retrviving a specific individual user form individual database table ");
		ResponseEntity<Individual> response = restTemplate.exchange(RequestUtils.getAuthorizedGetRequest(request,
				RequestUtils.getURI(URL.INDIVIDUAL,"byUserId/"+userId)), Individual.class);
		return response.getBody() ;
	}

	@Override
	public void addNewExperience(HttpServletRequest request, Experience experience) {
		log.info("Adding a new individual Expereince");
		RequestEntity<Experience> requestEntity = RequestUtils.getAuthorizedPostRequest(request,
				experience, RequestUtils.getURI(URL.EXPERIENCE,""));
		restTemplate.exchange(requestEntity,(Class<Object>)null);
	}

	@Override
	public void addNewSkill(HttpServletRequest request, IndividualSkill skill) {
		log.info("Adding a new Skill in individual");
		RequestEntity<IndividualSkill> requestEntity = RequestUtils.getAuthorizedPostRequest(request,
				skill, RequestUtils.getURI(URL.INDIVIDUAL_SKILL,""));
		restTemplate.exchange(requestEntity,(Class<Object>)null );
	}
	
	@Override
	public void addNewProfessionalData(HttpServletRequest request, ProfessionalData data) {
		log.info("Adding a new individual professionalData");
		RequestEntity<ProfessionalData> requestEntity = RequestUtils.getAuthorizedPostRequest(request,
				data, RequestUtils.getURI(URL.PROFESSIONAL_DATA,""));
		restTemplate.exchange(requestEntity,(Class<Object>)null);
		
	}

	@Override
	public void deleteExperience(HttpServletRequest request, Long expereinceId) {
		log.info("Deleting individual experience");
		RequestEntity<?> requestEntity = RequestUtils.getAuthorizedGetRequest(request,null);
		restTemplate.exchange(RequestUtils.getURI(URL.EXPERIENCE,""+ expereinceId), 
					HttpMethod.DELETE ,requestEntity , (Class<Object>)null);
		
	}

	@Override
	public void deleteSkill(HttpServletRequest request, Long skillId) {
		log.info("Deleting individual skill");
		RequestEntity<?> requestEntity = RequestUtils.getAuthorizedGetRequest(request, null);
		restTemplate.exchange(RequestUtils.getURI(URL.INDIVIDUAL_SKILL,""+skillId), 
					HttpMethod.DELETE ,requestEntity , (Class<Object>)null);
	}
	
	@Override
	public void deleteProfessionalData(HttpServletRequest request, Long dataId) {
		log.info("Deleting individual professional data");
		RequestEntity<?> requestEntity = RequestUtils.getAuthorizedGetRequest(request,null);
		restTemplate.exchange(RequestUtils.getURI(URL.PROFESSIONAL_DATA,""+dataId), 
					HttpMethod.DELETE ,requestEntity , (Class<Object>)null);
	}
}
