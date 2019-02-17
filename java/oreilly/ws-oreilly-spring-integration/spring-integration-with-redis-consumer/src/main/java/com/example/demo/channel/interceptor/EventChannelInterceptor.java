package com.example.demo.channel.interceptor;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.stereotype.Component;

import com.example.demo.util.Color;
import com.example.demo.util.ColorWriterUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component("eventChannelInterceptor")
public class EventChannelInterceptor extends ChannelInterceptorAdapter {

	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {

		ColorWriterUtils.printInfo(log, Color.CYAN,
				"[interceptor] Message: ''" + message.getPayload() + "' intercepted from channel: " + channel);
		return super.preSend(message, channel);
	}

}
