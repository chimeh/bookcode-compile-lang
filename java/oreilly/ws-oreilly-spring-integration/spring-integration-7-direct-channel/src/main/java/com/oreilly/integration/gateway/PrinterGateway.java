package com.oreilly.integration.gateway;

import org.springframework.messaging.Message;

public interface PrinterGateway {

	public void print(Message<?> message);
}
