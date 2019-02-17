package com.oreilly.integration.custom.filter;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

public class CustomFilter implements MessageSelector {

	@Override
	public boolean accept(Message<?> message) {
		return message.getHeaders().containsKey("messageNumber")
				&& (int) message.getHeaders().get("messageNumber") % 2 == 0;
	}

}
