package com.oreilly.integration.custom.aggregator;

import java.util.Map;

import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.aggregator.AbstractAggregatingMessageGroupProcessor;
import org.springframework.integration.store.MessageGroup;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAggregator extends AbstractAggregatingMessageGroupProcessor {

	@Override
	protected Object aggregatePayloads(MessageGroup group, Map<String, Object> defaultHeaders) {
		StringBuilder builder = new StringBuilder();

		for (Message<?> message : group.getMessages()) {
			log.info("correlationId: {}",
					message.getHeaders().get(IntegrationMessageHeaderAccessor.CORRELATION_ID));
			builder.append(message.getPayload().toString());
		}
		log.info("---");
		return MessageBuilder.withPayload(builder.toString())
				.copyHeaders(defaultHeaders).build();
	}

}
