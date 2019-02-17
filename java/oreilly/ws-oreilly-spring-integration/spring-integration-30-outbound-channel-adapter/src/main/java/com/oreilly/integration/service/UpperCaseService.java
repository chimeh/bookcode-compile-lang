package com.oreilly.integration.service;

import java.util.concurrent.TimeUnit;

import com.oreilly.integration.model.Person;

import lombok.SneakyThrows;

public class UpperCaseService {

	@SneakyThrows
	public String execute(Person person) {
		TimeUnit.SECONDS.sleep(2);
		return (person.getFirstName() + " " + person.getLastName()).toUpperCase();
	}

}
