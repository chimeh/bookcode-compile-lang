package com.oreilly.integration.service;

import com.oreilly.integration.model.Person;

public class UpperCaseService {

	public String execute(Person person) {
		return (person.getFirstName() + " " + person.getLastName()).toUpperCase();
	}

}
