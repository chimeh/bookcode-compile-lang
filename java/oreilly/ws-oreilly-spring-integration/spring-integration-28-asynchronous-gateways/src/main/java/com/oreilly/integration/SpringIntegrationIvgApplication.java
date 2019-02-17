package com.oreilly.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.oreilly.integration.gateway.EnhancedPrinterGateway;
import com.oreilly.integration.model.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@ImportResource("integration-context.xml")
public class SpringIntegrationIvgApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationIvgApplication.class, args);
	}

	@Slf4j
	@Component
	@Order(1)
	static class Runner implements ApplicationRunner {

		@Autowired
		private EnhancedPrinterGateway printerGateway;

		@Override
		public void run(ApplicationArguments args) throws Exception {

			log.info("[ApplicationRunner] Spring Integration");

			for (int i = 0; i < 5; i++) {

				Person person = Person.builder().lastName("Garcia " + i).firstName("Ivan " + i).build();

				log.info("1) sending message " + person);

				try {
					this.printerGateway.print(person);
				} catch (Exception ex) {
					log.info("we got an error, message didnt delivered: {}", ex.getMessage());
				}
			}

			System.out.println("====");

			for (int i = 5; i < 10; i++) {

				Person person = Person.builder().lastName("Garcia " + i).firstName("Ivan " + i).build();

				log.info("2 ) sending message " + person);

				try {
					ListenableFuture<String> future = this.printerGateway.upperCase(person);

					future.addCallback(new ListenableFutureCallback<String>() {

						@Override
						public void onSuccess(String result) {
							log.info("success, getting result: {}", result);
						}

						@Override
						public void onFailure(Throwable ex) {
							log.info("error, getting result. Ex {}", ex.getMessage());
						}
					});

				} catch (Exception ex) {
					log.info("we got an error, message didnt delivered: {}", ex.getMessage());
				}
			}
		}

	}

}
