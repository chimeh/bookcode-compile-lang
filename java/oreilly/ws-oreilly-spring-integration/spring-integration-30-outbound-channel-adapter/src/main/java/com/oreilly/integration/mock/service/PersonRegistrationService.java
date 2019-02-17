package com.oreilly.integration.mock.service;

import com.oreilly.integration.model.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonRegistrationService {

	public void registerEmail(Person person) {
		log.info("Outbound Channel Adapter delivered a message to external system.");
		log.info("email created for {} as: {}", person.getFirstName(),
				person.getFirstName() + "." + person.getLastName() + "@mail.com");
	}
}
