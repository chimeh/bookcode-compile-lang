package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import com.example.demo.model.Post;
import com.example.demo.service.EnqueueService;
import com.example.demo.util.Color;
import com.example.demo.util.ColorWriterUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringIntegrationWithRedisProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationWithRedisProducerApplication.class, args);
	}

	@Autowired
	private EnqueueService enqueueService;

	@Bean
	public CommandLineRunner runner(ThreadPoolTaskScheduler threadPoolTaskScheduler) {

		return new CommandLineRunner() {

			Long messageCount = 0L;

			@Override
			public void run(String... args) throws Exception {

				ColorWriterUtils.printInfo(log, Color.RED, "Producer started");

				threadPoolTaskScheduler.scheduleWithFixedDelay(new Runnable() {

					@Override
					public void run() {
						messageCount++;

						Post post = new Post();
						post.setUrl("url " + messageCount);
						post.setTitle("title " + messageCount);
						post.setEmails(Arrays.asList("some" + messageCount + "@email.com",
								"other" + messageCount + "@email.com"));

						enqueueService.enqueue(post);
					}
				}, 200);

			}
		};
	}

	@Bean
	public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(5);
		threadPoolTaskScheduler.setThreadNamePrefix(
				"pub-scheduler");
		return threadPoolTaskScheduler;
	}
}
