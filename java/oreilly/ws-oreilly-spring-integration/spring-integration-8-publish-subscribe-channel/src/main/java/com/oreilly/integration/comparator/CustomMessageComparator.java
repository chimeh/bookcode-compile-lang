package com.oreilly.integration.comparator;

import java.util.Comparator;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component("customMessageComparator")
public class CustomMessageComparator implements Comparator<Message<String>> {

	@Override
	public int compare(Message<String> message1, Message<String> message2) {
		String payload1 = message1.getPayload();
		String payload2 = message2.getPayload();

		boolean isPayloadEven1 = Integer.valueOf(payload1.substring(payload1.length() - 1)) % 2 == 0;
		boolean isPayloadEven2 = Integer.valueOf(payload2.substring(payload2.length() - 1)) % 2 == 0;

		if ((isPayloadEven1 && isPayloadEven2) || (!isPayloadEven1 && !isPayloadEven2)) {
			return 0;
		} else if (isPayloadEven1)
			return -1;
		else {
			return 1;
		}
	}

}
