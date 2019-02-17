package com.oreilly.integration.service;

import org.springframework.messaging.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FiveNumberPrintService {

	public void print(Message<?> message) {
		log.info("[fiveNumberPrintService] Message received");
		log.info("[fiveNumberPrintService] message payload, this is five ! " + message.getPayload());
		log.info("--");
	}
}
