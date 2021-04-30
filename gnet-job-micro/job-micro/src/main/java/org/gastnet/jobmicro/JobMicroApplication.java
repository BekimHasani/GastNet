package org.gastnet.jobmicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class JobMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobMicroApplication.class, args);
	}

}
