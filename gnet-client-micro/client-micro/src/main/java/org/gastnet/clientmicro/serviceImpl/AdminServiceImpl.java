package org.gastnet.clientmicro.serviceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.gastnet.clientmicro.enumeration.ReportStatus;
import org.gastnet.clientmicro.enumeration.Role;
import org.gastnet.clientmicro.enumeration.URL;
import org.gastnet.clientmicro.model.Business;
import org.gastnet.clientmicro.model.BusinessListWrapper;
import org.gastnet.clientmicro.model.Individual;
import org.gastnet.clientmicro.model.IndividualListWrapper;
import org.gastnet.clientmicro.model.Report;
import org.gastnet.clientmicro.model.ReportListWrapper;
import org.gastnet.clientmicro.model.User;
import org.gastnet.clientmicro.model.UserListWrapper;
import org.gastnet.clientmicro.service.AdminService;
import org.gastnet.clientmicro.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private RestTemplate restTemplate;

	public List<Report> getReports(HttpServletRequest request, ReportStatus reportStatus) {
		log.info("Fetching all data from report database table");
		RequestEntity<ReportStatus> requestEntity = RequestUtils.getAuthorizedPostRequest(request, reportStatus,
				RequestUtils.getURI(URL.ADMIN, "undoneReports"));
		ResponseEntity<ReportListWrapper> response = restTemplate.exchange(requestEntity, ReportListWrapper.class);
		return response.getBody().getReports();
	}
	
	@Override
	public List<User> getAllAdmins(HttpServletRequest request, Role role){
		log.info("Fetching all data from admin database table");
		RequestEntity<Role> requestEntity = RequestUtils.getAuthorizedPostRequest(request, role, RequestUtils.getURI(URL.ADMIN,"all"));
		ResponseEntity<UserListWrapper> response = restTemplate.exchange(requestEntity, UserListWrapper.class);
		return response.getBody().getUsers();
	}

	@Override
	public List<Individual> getAllIdividuals(HttpServletRequest request) {
		log.info("Fetching all data from individual database table");
		ResponseEntity<IndividualListWrapper> response = restTemplate.exchange(
				RequestUtils.getAuthorizedGetRequest(request,RequestUtils.getURI(URL.INDIVIDUAL, "")),IndividualListWrapper.class);
		return response.getBody().getIndividuals();
	}

	@Override
	public List<Business> getAllBusinesses(HttpServletRequest request){
		log.info("Fetching all data from business database table");
		ResponseEntity<BusinessListWrapper> response = restTemplate.exchange(
					RequestUtils.getAuthorizedGetRequest(request, RequestUtils.getURI(URL.BUSINESS, "")),BusinessListWrapper.class);	
		return response.getBody().getBusinesses();
	}

}
