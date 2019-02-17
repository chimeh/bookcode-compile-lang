package com.oreilly.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("integration-context.xml")
public class SpringIntegrationIvgApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationIvgApplication.class, args);
	}
}
