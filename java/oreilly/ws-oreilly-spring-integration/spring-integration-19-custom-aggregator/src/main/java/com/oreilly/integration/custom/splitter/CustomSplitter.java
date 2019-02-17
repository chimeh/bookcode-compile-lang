package com.oreilly.integration.custom.splitter;

import java.util.Arrays;

import org.springframework.messaging.Message;

public class CustomSplitter /*extends AbstractMessageSplitter*/ {

	//@Override
	public Object splitMessage(Message<?> message) {
		// 1. Return a collection or array of messages
		// 2. Return a collection or array of none messages
		// 3. Return a message or a none message

		return Arrays.asList(message.getPayload().toString().split(" "));
	}

}
