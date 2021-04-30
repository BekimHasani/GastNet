package org.gastnet.gatewayservice.security.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gastnet.gatewayservice.model.UserPrincipals;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

private UserDetailsService userDetailsService;
	
	public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
		super(authenticationManager);
		this.userDetailsService = userDetailsService;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		String header = request.getHeader(JwtProperties.HEADER_STRING);
		
		if(header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX)) {
			chain.doFilter(request, response);
			return;
		}
		
		Authentication authentication = getUsernamePasswordAuthentication(request);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		chain.doFilter(request, response);
	}

	private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {
		
		String token = request.getHeader(JwtProperties.HEADER_STRING);
		if(token != null) {
			String str = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET.getBytes()))
					.build()
					.verify(token.replace(JwtProperties.TOKEN_PREFIX, ""))
					.getSubject();
			String [] content = str.split("/");
			
			if(content[0] != null) {
				UserPrincipals principal = (UserPrincipals) userDetailsService.loadUserByUsername(content[0]);
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(content[0], null , principal.getAuthorities());
				return auth;
			}
			return null;
		}
		return null;
	}

}
