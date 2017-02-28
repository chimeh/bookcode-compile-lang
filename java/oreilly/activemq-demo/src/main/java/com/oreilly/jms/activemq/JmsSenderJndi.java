package com.oreilly.jms.activemq;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * User: Jama
 * Date: 11/30/2014
 */
public class JmsSenderJndi {
    public static void main(String[] args) throws NamingException, JMSException {
        Context context = new InitialContext();
        Connection connection = ((ConnectionFactory) context.lookup("ConnectionFactory")).createConnection();


        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = (Queue) context.lookup("EM_TRADE.Q");
        MessageProducer sender = session.createProducer(queue);

        TextMessage message = session.createTextMessage("SELL AAPL 1000 SHARES");
        message.setStringProperty("TraderName", "Jama");
        sender.send(message);

        System.out.println("message sent");
    }
}
