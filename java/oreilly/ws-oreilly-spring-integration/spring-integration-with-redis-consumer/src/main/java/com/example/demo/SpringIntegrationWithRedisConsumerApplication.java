package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.example.demo.util.Color;
import com.example.demo.util.ColorWriterUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableIntegration
public class SpringIntegrationWithRedisConsumerApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringIntegrationWithRedisConsumerApplication.class, args);

		int i = 0;
		for (String bean : ctx.getBeanDefinitionNames()) {
			i++;
			System.out.println(i + ") " + bean);
		}
	}

	@Bean
	public CommandLineRunner runner(ThreadPoolTaskScheduler threadPoolTaskScheduler) {

		return (args) -> {

			ColorWriterUtils.printInfo(log, Color.RED, "Consumer started");

		};
	}
}
