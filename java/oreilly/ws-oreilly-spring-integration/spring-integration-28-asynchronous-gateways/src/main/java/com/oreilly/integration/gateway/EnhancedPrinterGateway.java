package com.oreilly.integration.gateway;

import org.springframework.util.concurrent.ListenableFuture;

import com.oreilly.integration.model.Person;

public interface EnhancedPrinterGateway {

	public void print(Person person);

	public ListenableFuture<String> upperCase(Person person);
}
