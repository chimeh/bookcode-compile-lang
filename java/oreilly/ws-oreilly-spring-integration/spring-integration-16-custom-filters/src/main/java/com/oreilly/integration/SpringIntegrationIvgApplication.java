package com.oreilly.integration;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.oreilly.integration.gateway.PrinterGateway;
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
		private PrinterGateway printerGateway;

		@Override
		public void run(ApplicationArguments args) throws Exception {

			log.info("[ApplicationRunner] Spring Integration");

			for (int i = 0; i < 10; i++) {

				Person person = Person.builder().id(i).name(i % 2 == 0 ? "Ivan" : "Ivan " + i).build();

				Message<?> message = MessageBuilder.withPayload(person)
						.setHeader("messageNumber", i)
						.build();
				log.info("sending message " + i);

				try {
					this.printerGateway.print(message);
				} catch (Exception ex) {
					log.info("we got an error, message didnt delivered: {}", ex.getMessage());
				}
			}

			Message<?> message = MessageBuilder.withPayload(new Date())
					.build();
			log.info("sending message " + message);

			this.printerGateway.print(message);

		}

	}

}
