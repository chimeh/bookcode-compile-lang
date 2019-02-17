package com.oreilly.integration.service;

import org.springframework.messaging.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnyService {

	public void print(Message<?> message) {
		log.info("[anyService] Message received");
		log.info("[anyService] message payload: " + message.getPayload());
		log.info("--");
	}
}
