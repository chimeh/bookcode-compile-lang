package com.oreilly.jms.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * User: Jama
 * Date: 11/30/2014
 */
public class JMSReceiver {

    public static void main(String[] args) throws JMSException {
        Connection connection = new ActiveMQConnectionFactory("tcp://localhost:61616").createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("EM_TRADE.Q");
        MessageConsumer receiver = session.createConsumer(queue);

        TextMessage message = ((TextMessage) receiver.receive());

        System.out.println(message.getText());

    }
}
