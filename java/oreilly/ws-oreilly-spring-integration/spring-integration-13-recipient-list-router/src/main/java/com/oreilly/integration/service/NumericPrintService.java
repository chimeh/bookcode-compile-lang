package com.oreilly.integration.service;

import org.springframework.messaging.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NumericPrintService {

	public void print(Message<?> message) {
		log.info("[numericPrintService] Message received");
		log.info("[numericPrintService] message payload: " + message.getPayload());
		log.info("--");
	}
}
