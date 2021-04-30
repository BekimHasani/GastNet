package org.gastnet.clientmicro.service;

import javax.servlet.http.HttpServletRequest;

import org.gastnet.clientmicro.model.UserCredentials;
import org.springframework.web.client.HttpClientErrorException;

public interface AuthenticationService {

	void getUserToken(UserCredentials user, HttpServletRequest request) throws HttpClientErrorException;

	void invalidateUserToken(HttpServletRequest request);
}
