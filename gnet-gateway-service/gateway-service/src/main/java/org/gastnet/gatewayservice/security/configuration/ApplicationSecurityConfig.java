
package org.gastnet.gatewayservice.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private OidcUserService oidcUserService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		return provider;

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
			.httpBasic()
		.and()
			.addFilter(new JwtAuthenticationFilter(authenticationManager()))
			.addFilter(new JwtAuthorizationFilter(authenticationManager(), this.userDetailsService))
			.authorizeRequests()
			.antMatchers("/", "/login", "/login/oauth2", "/login/oauth2/**", "/oauth2/authorization/google","/register/**").permitAll()
			.antMatchers("/users/admin/*").hasRole("ADMIN")
			.anyRequest().authenticated()
		 .and()
		 	.logout()
		 		.logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK)).permitAll()
		 .and()
		 	.oauth2Login(oauth2 -> 
		 		oauth2.userInfoEndpoint().oidcUserService(oidcUserService)
		 			.and().defaultSuccessUrl("http://localhost:8090/adminDashboard"));
		 }

}
