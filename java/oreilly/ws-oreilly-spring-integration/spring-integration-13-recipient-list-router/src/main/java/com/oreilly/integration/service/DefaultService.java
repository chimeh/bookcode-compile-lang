package com.oreilly.integration.service;

import org.springframework.messaging.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultService {

	public void print(Message<?> message) {
		log.info("[defaultService] Message received");
		log.info("[defaultService] message payload: " + message.getPayload());
		log.info("--");
	}
}
