package com.oreilly.integration.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
	private int id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
}
