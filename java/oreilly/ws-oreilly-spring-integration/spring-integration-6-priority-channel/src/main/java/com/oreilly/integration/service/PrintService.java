package com.oreilly.integration.service;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("printService")
public class PrintService {

	public Message<String> print(Message<String> message) {
		log.info("Message received");
		log.info("message headers:");
		MessageHeaders headers = message.getHeaders();
		for (String key : headers.keySet()) {
			log.info("header [key: " + key + " => value: " + headers.get(key) + "]");
		}
		log.info("message payload: " + message.getPayload());
		log.info("sending reply...");
		log.info("--");

		return MessageBuilder.withPayload("Sending Reply for message: " + headers.get("messageNumber")).build();
	}
}
