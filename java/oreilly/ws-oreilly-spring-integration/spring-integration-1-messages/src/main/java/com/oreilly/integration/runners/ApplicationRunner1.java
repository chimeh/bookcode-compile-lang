package com.oreilly.integration.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;

//@Component
@Order(2)
public class ApplicationRunner1 implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("[ApplicationRunner] hello world 2 works");
	}

}
