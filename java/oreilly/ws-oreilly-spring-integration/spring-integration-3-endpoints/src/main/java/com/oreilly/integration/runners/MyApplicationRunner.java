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

@Component
@Order(1)
public class MyApplicationRunner implements ApplicationRunner {

	@Autowired
	private DirectChannel messageInputChannel;

	@Autowired
	private DirectChannel messageOutputChannel;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println("[ApplicationRunner] Spring Integration");

		messageOutputChannel.subscribe(new MessageHandler() {

			@Override
			public void handleMessage(Message<?> message) throws MessagingException {
				System.out.println(
						"[Message Handler from Message Output Channel] message payload: " + message.getPayload());
			}
		});

		Message<String> message = MessageBuilder.withPayload("Other Hello World")
				.setHeader("newHeader", "newHeaderValue").build();

		messageInputChannel.send(message);
	}

}
