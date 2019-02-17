package com.oreilly.integration;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationApplication implements ApplicationRunner {

	@Autowired
	private PersonGateway gateway;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) throws InterruptedException, ExecutionException {
		Person person = new Person(4,"Jane","Doe");
		this.gateway.save(person);
	}
	

}
