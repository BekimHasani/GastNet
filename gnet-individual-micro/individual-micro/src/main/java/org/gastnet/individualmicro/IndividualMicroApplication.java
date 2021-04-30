package org.gastnet.individualmicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class IndividualMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndividualMicroApplication.class, args);

	}

}
