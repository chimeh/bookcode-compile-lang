package com.oreilly.integration.service;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("printService")
public class PrintService {

	public void print(Message<String> message) {

		// If a service activator throws an Exception, if fails....
		// Message architecture will send the message to the other endpoint on the load balancer, having failover.
		throw new RuntimeException("This is an error");
		/*log.info("Message received");
		log.info("message payload: " + message.getPayload());
		log.info("--");*/
	}
}
