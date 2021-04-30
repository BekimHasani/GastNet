package org.gastnet.gatewayservice.security.configuration;

import java.util.Date;
import java.util.Optional;

import org.gastnet.gatewayservice.enumeration.Role;
import org.gastnet.gatewayservice.model.User;
import org.gastnet.gatewayservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleOidcUserService extends OidcUserService {
	
	@Autowired
	private UserService userController;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
		OidcUser oidcUser = super.loadUser(userRequest);

        try {
             return processOidcUser(userRequest, oidcUser);
        } catch (Exception ex) {
            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

     private OidcUser processOidcUser(OidcUserRequest userRequest, OidcUser oidcUser) {
        String email = oidcUser.getAttributes().getOrDefault("email", "").toString();
        Optional<User> userOpt = Optional.ofNullable(userController.gatUserByEmail(email));
        if (!userOpt.isPresent()) {
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setStatus(true);
            newUser.setRole(Role.INDIVIDUAL);
            newUser.setCreationDate(new Date());
            newUser.setPassword(null);
            newUser.setGoogleUser(true);
    		restTemplate.postForEntity("http://user-micro/users/user", newUser, User.class);
    		return newUser;
        }
        return userOpt.get();
     }
}
