package com.example.demo.util;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ColorWriterUtils implements ApplicationContextAware {

	private static ApplicationContext ctx;

	private static IColorWriter colorWriter;

	@PostConstruct
	private void setup() {
		colorWriter = ctx.getBean(IColorWriter.class);
	}

	public static void printInfo(Logger log, Color color, String message) {
		log.info("{}", colorWriter.getColoredMessage(color, message));
	}

	public static void printDebug(Logger log, Color color, String message) {
		log.debug("{}", colorWriter.getColoredMessage(color, message));
	}

	public static void printTrace(Logger log, Color color, String message) {
		log.trace("{}", colorWriter.getColoredMessage(color, message));
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ctx = applicationContext;
	}
}
