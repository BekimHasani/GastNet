package org.gastnet.gatewayservice.config;

import org.gastnet.gatewayservice.error.handler.RestTemplateResponseErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GatewayBeans {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplateBuilder()
				.errorHandler(new RestTemplateResponseErrorHandler())
				.build();
	}

	@Bean
	public BCryptPasswordEncoder getPasswordEcoder() {
		return new BCryptPasswordEncoder();
	}
}
