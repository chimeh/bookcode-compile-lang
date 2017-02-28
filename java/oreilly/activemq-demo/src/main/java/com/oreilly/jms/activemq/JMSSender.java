package com.oreilly.jms.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * User: Jama
 * Date: 11/30/2014
 */
public class JMSSender {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = factory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue("EM_TRADE.Q");

        MessageProducer sender = session.createProducer(queue);

        TextMessage message = session.createTextMessage("BUY AAPL 1000 SHARES");
        sender.send(message);

        System.out.println("message sent");
        connection.close(); // this will close session as well.

    }
}
