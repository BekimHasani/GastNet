	package org.gastnet.gatewayservice.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.gastnet.gatewayservice.enumeration.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;


public class User implements OidcUser {

	private Long userId;
	private String email;
	private String password;
	private Date creationDate;
	private boolean status;
	private Role role;
	private boolean googleUser;
	
    private Map<String, Object> attributes = new HashMap<String, Object>();
    
	public User() {
		super();
	}

	public User(Map<String, Object> attributes) {
		this.attributes = attributes;
		this.email = this.attributes.getOrDefault("email", "").toString();
		this.role = Role.INDIVIDUAL;
	}

	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public boolean isGoogleUser() {
		return googleUser;
	}

	public void setGoogleUser(boolean googleUser) {
		this.googleUser = googleUser;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@Override
	public String getName() {
		return email;
	}

	@Override
	public Map<String, Object> getClaims() {
		HashMap<String, Object> claims = new HashMap<>();
		claims.put("claim", true);
		return claims;
	}

	@Override
	public OidcUserInfo getUserInfo() {
		return null;
	}

	@Override
	public OidcIdToken getIdToken() {
		return new OidcIdToken(email, Instant.now(), Instant.now().plusSeconds(86400), getClaims());
	}
	
	

}
