package com.oreilly.integration.gateway;

import com.oreilly.integration.model.Person;

public interface EnhancedPrinterGateway {

	public void print(Person person);

	public String upperCase(Person person);
}
