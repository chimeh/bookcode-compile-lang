package com.oreilly.integration.mock.service;

import com.oreilly.integration.model.Person;

public class PersonDirectoryService {

	public Person findNewPeople() {

		return Person.builder().id(123).firstName("Ilse Noemi").lastName("Hdz").build();
	}
}
