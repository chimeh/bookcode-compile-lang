package com.oreilly.integration.service;

import org.springframework.messaging.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntermediumService {

	public Message<?> print(Message<?> message) {
		log.info("[intermediumService] Message received (correlationId: " + message.getHeaders().get("correlationId")
				+ ")");
		log.info("[intermediumService] message payload: " + message.getPayload());
		log.info("--");

		return message;
	}
}
