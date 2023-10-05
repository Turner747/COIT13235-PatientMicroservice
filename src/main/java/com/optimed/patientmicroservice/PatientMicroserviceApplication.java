
package com.optimed.patientmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.optimed.patientmicroservice.repository")
@EntityScan(basePackages = "com.optimed.patientmicroservice.model")
public class PatientMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientMicroserviceApplication.class, args);
	}

}