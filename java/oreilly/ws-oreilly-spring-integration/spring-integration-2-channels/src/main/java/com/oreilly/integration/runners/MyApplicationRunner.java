package com.oreilly.integration.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import com.oreilly.integration.service.PrintService;

@Component
@Order(1)
public class MyApplicationRunner implements ApplicationRunner {

	@Autowired
	private DirectChannel channel;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println("[ApplicationRunner] Spring Integration");

		channel.subscribe(new MessageHandler() {

			PrintService printService = new PrintService();

			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				printService.print((Message<String>) message);
			}
		});

		Message<String> message = MessageBuilder.withPayload("Other Hello World")
				.setHeader("newHeader", "newHeaderValue").build();

		channel.send(message);
	}

}
