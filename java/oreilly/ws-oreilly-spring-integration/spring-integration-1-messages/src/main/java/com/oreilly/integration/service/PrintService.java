package com.oreilly.integration.service;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

public class PrintService {

	public void print(Message<String> message) {
		System.out.println("Message received");
		System.out.println("message headers:");
		MessageHeaders headers = message.getHeaders();
		for(String key: headers.keySet()) {
			System.out.println("header [key: "+key+" => value: "+headers.get(key)+"]");
		}
		System.out.println("message payload: " + message.getPayload());
		System.out.println("--");
	}
}
