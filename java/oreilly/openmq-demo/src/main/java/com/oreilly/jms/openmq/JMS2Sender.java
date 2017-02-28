package com.oreilly.jms.openmq;

import com.sun.messaging.ConnectionFactory;

import javax.jms.DeliveryMode;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Queue;

/**
 * User: Jama
 * Date: 11/30/2014
 */
public class JMS2Sender {
    public static void main(String[] args) throws JMSException {
         ConnectionFactory factory = new com.sun.messaging.ConnectionFactory();
         try (JMSContext context = factory.createContext()) {
             Queue queue = context.createQueue("EM_JMS2_TRADE.Q");
             context.createProducer()
                     .setProperty("TraderName","Mark")
//                     .setDeliveryMode(DeliveryMode.NON_PERSISTENT)
                     .send(queue, "SELL AAPL 1500 SHARES");
             System.out.println("Message sent");
         }
     }
}
