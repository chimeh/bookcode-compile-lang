package com.oreilly.jms.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * User: Jama
 * Date: 11/30/2014
 */
public class JMSAsyncReceiver implements MessageListener {
    public JMSAsyncReceiver() {
        try {
            Connection connection = new ActiveMQConnectionFactory("tcp://localhost:61616").createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            connection.start();
            Queue queue = session.createQueue("EM_TRADE.Q");
            MessageConsumer receiver = session.createConsumer(queue);
            receiver.setMessageListener(this);
            System.out.println("waiting for messages");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessage(Message message) {
        try {
            String traderName = message.getStringProperty("TraderName");
            String text = ((TextMessage) message).getText();
            System.out.println(text + ", trader " + traderName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Thread() {
            public void run() {
                new JMSAsyncReceiver();
            }
        }.run();
    }
}
