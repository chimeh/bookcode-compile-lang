package com.oreilly.integration.custom.header.enricher;

import org.springframework.messaging.Message;

import com.oreilly.integration.model.Person;

public class CustomHeaderEnricher {

	public String getHeaderValue(Message<?> message) {

		return "this is a header value added to message of person '" + ((Person) message.getPayload()).getFirstName()
				+ "'";
	}
}
