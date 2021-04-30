package org.gastnet.clientmicro.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JwtConverter {

	public String getUserEmailFromToken(String token) {
		if (token != null) {
			String credentials = JWT.require(Algorithm.HMAC512(JwtProperties.SECRET.getBytes()))
					.build()
					.verify(token.replace(JwtProperties.TOKEN_PREFIX, ""))
					.getSubject();
			String [] email = credentials.split(" ");
			return email[0];
		}
		return null;
	}
}
