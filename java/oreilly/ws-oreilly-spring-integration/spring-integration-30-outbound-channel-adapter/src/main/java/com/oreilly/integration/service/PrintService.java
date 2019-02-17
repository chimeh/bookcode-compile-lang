package com.oreilly.integration.service;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintService {

	public void print(Message<?> message) {
		log.info("message headers:");
		MessageHeaders headers = message.getHeaders();
		for (String key : headers.keySet()) {
			log.info("header [key: " + key + " => value: " + headers.get(key) + "]");
		}
		log.info("[printService] Message received");
		log.info("[printService] message payload: " + message.getPayload());
		log.info("--");
	}
}
