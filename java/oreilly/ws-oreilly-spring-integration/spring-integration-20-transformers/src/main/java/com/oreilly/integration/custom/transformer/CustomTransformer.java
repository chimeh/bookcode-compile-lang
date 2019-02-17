package com.oreilly.integration.custom.transformer;

import org.springframework.messaging.Message;

public class CustomTransformer {

	public String transform(Message<?> message) {

		String[] tokens = message.getPayload().toString().split(" ");

		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (String token : tokens) {
			sb.append(token).reverse();

			if (i < tokens.length)
				sb.append(" ");
		}

		return sb.toString();
	}
}
