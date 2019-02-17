package com.oreilly.integration.runners;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.oreilly.integration.gateway.PrinterGateway;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Order(1)
public class MyApplicationRunner implements ApplicationRunner {

	@Autowired
	private PrinterGateway printerGateway;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		log.info("[ApplicationRunner] Spring Integration");

		List<Future<Message<String>>> futures = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			Message<String> message = MessageBuilder.withPayload("Printing message payload for message " + (i + 1))
					.setHeader("messageNumber", i + 1).build();
			log.info("sending message " + (i + 1));

			futures.add(this.printerGateway.print(message));
		}

		for (Future<Message<String>> future : futures) {

			log.info("response received from gateway: " + future.get().getPayload());
		}

	}

}
