package com.oreilly.integration.service;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("printService")
public class PrintService {

	public void print(Message<String> message) {
		log.info("[printService] Message received");
		log.info("[printService] message payload: " + message.getPayload());
		log.info("--");
	}
}
