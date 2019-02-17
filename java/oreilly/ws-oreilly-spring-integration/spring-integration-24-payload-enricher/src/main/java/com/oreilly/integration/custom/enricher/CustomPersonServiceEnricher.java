package com.oreilly.integration.custom.enricher;

import org.springframework.messaging.Message;

import com.oreilly.integration.model.Person;

public class CustomPersonServiceEnricher {

	public String getPhoneNumber(Message<Person> message) {
		return "123-123-123 : person '" + message.getPayload().getFirstName() + "'";
	}
}
