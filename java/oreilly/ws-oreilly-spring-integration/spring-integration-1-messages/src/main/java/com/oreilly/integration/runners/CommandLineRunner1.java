package com.oreilly.integration.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

//@Component
@Order(1)
public class CommandLineRunner1 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("[CommandLineRunner] hello world 1 works");
	}

}
