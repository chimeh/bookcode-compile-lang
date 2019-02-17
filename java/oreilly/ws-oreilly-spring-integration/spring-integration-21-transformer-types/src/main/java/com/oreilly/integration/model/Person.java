package com.oreilly.integration.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
	private int id;
	private String firstName;
	private String lastName;

	@Override
	public String toString() {
		return "This is a Person with values: [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
