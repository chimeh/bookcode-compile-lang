package com.oreilly.integration.custom.router;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class CustomRouter extends AbstractMessageRouter {

	@Autowired
	private MessageChannel integerChannel;

	@Autowired
	private MessageChannel stringChannel;

	@Autowired
	private MessageChannel defaultChannel;

	@Override
	protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {

		Collection<MessageChannel> targetChannels = new ArrayList<>();

		if (message.getPayload().getClass().equals(Integer.class))
			targetChannels.add(integerChannel);
		else if (message.getPayload().getClass().equals(String.class))
			targetChannels.add(stringChannel);
		else
			targetChannels.add(defaultChannel);

		return targetChannels;
	}

}
