package com.oreilly.integration.mock.service;

import com.oreilly.integration.model.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonDirectoryService {

	public Person findNewPeople() {
		log.info("Inbound Channel Adapter has polled this service.");
		return Person.builder().id(123).firstName("Ilse Noemi").lastName("Hdz").build();
	}
}
