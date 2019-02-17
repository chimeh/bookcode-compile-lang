package com.oreilly.integration.service;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("numericPrintService")
public class NumericPrintService {

	public void print(Message<?> message) {
		log.info("[numericPrintService] Message received");
		log.info("[numericPrintService] message payload: " + message.getPayload());
		log.info("--");
	}
}
