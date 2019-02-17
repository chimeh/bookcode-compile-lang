package com.oreilly.integration.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyApplicationRunner implements ApplicationRunner {

	@Autowired
	private DirectChannel messageInputChannel;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println("[ApplicationRunner] Spring Integration");

		Message<String> message = MessageBuilder.withPayload("Other Hello World")
				.setHeader("newHeader", "newHeaderValue").build();

		MessagingTemplate template = new MessagingTemplate();

		Message<String> returnMessage = (Message<String>) template.sendAndReceive(messageInputChannel, message);

		System.out.println(returnMessage.getPayload());

	}

}
