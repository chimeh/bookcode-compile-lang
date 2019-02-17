package com.oreilly.integration.channel.interceptor;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("customChannelInterceptor")
public class CustomChannelInterceptor extends ChannelInterceptorAdapter {

	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		log.info("Message intercepted from channel: {}", channel);
		Message<?> msg = MessageBuilder.withPayload(message.getPayload() + ", message intercepted").build();
		return super.preSend(msg, channel);
	}

}
