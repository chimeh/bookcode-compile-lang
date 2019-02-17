package com.oreilly.integration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;

import com.oreilly.integration.service.PrintService;

@SpringBootApplication
@ImportResource("integration-context.xml")
public class SpringIntegrationIvgApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationIvgApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("[ApplicationRunner] Spring Integration - main");

		/*
		 * All Known Implementing Classes: ErrorMessage, GenericMessage
		 */
		Map<String, Object> messageHeadersMap = new HashMap<>();
		messageHeadersMap.put("key", "value");
		MessageHeaders headers = new MessageHeaders(messageHeadersMap);

		Message<String> message = new GenericMessage<>("Hello World", headers);

		Message<String> message2 = MessageBuilder.withPayload("Other Hello World")
				.setHeader("newHeader", "newHeaderValue").build();

		PrintService printService = new PrintService();

		printService.print(message);

		printService.print(message2);
	}

	// @Bean
	// @Order(2) // not works
	public CommandLineRunner runner2() {
		return (args) -> {
			System.out.println("[CommandLineRunner] hello world 2 not works");
		};
	}

	// @Bean
	// @Order(1) // not works
	public CommandLineRunner runner1() {
		return (args) -> {
			System.out.println("[CommandLineRunner] hello world 1 not works");
		};
	}
}
