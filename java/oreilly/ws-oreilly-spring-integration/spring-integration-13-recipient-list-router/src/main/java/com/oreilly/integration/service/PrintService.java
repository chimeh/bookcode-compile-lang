package com.oreilly.integration.service;

import org.springframework.messaging.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintService {

	public void print(Message<?> message) {
		log.info("[printService] Message received");
		log.info("[printService] message payload: " + message.getPayload());
		log.info("--");
	}
}
