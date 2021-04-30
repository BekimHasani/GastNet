package org.gastnet.gatewayservice.security.configuration;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gastnet.gatewayservice.model.LoginViewModel;
import org.gastnet.gatewayservice.model.UserPrincipals;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		LoginViewModel credentials = null;
		try {
			credentials = new ObjectMapper().readValue(request.getInputStream(), LoginViewModel.class);
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				credentials.getEmail(), 
				credentials.getPassword());
		
		Authentication auth = authenticationManager.authenticate(authenticationToken);

		return auth;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		UserPrincipals principal = (UserPrincipals) authResult.getPrincipal();
		String role = principal.getAuthorities().toString();
		
		String token = JWT.create().withSubject(principal.getUsername() +"/"+ role.substring(1,role.length()-1))
				.withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPARATION_DATE))
				.sign(HMAC512(JwtProperties.SECRET.getBytes()));

		response.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + token);
	}
	

}
