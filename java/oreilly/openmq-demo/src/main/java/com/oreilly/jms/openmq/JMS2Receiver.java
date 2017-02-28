package com.oreilly.jms.openmq;


import com.sun.messaging.ConnectionFactory;

import javax.jms.*;

/**
 * User: Jama
 * Date: 11/30/2014
 */
public class JMS2Receiver {
    public static void main(String[] args) throws JMSException {
        javax.jms.ConnectionFactory factory = new com.sun.messaging.ConnectionFactory();
        try (JMSContext context = factory.createContext()) {
            Queue queue = context.createQueue("EM_JMS2_TRADER.Q");
            Message message = context.createConsumer(queue).receive();
            String traderName = message.getStringProperty("TraderName");
            System.out.println("Trader - " + traderName + ", " + message.getBody(String.class));
        }
    }
}
