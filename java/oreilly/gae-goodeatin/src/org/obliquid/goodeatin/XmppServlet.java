package org.obliquid.goodeatin;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.xmpp.Message;
import com.google.appengine.api.xmpp.MessageBuilder;
import com.google.appengine.api.xmpp.SendResponse;
import com.google.appengine.api.xmpp.XMPPService;
import com.google.appengine.api.xmpp.XMPPServiceFactory;

@SuppressWarnings("serial")
public class XmppServlet extends HttpServlet {

        private static final Logger LOG = Logger.getLogger(XmppServlet.class.getName());

        @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
                XMPPService xmpp = XMPPServiceFactory.getXMPPService();
                Message message = xmpp.parseMessage(req);
                LOG.fine("Received IM from: " + message.getFromJid().getId() + " that says "
                                + message.getBody());

                Queue queue = QueueFactory.getDefaultQueue();
                queue.add();

                MemcacheService memcache = MemcacheServiceFactory.getMemcacheService();
                @SuppressWarnings("unchecked")
                List<Restaurant> restList = (List<Restaurant>) memcache
                                .get(GoodEatinServlet.TOP_RESTAURANTS);
                String responseBody = null;
                if (!message.getBody().equals("top3")) {
                        responseBody = "Sorry, I only understand `top3`.";
                } else if (restList != null) {
                        StringBuilder builder = new StringBuilder("Current top 3 restaurants: \r\n");
                        for (int i = 0; i < 3; i++) {
                                builder.append(restList.get(i).getName()).append("\r\n");
                        }
                        responseBody = builder.toString();
                } else {
                        responseBody = "Sorry, don't know yet. :-(";
                }
                Message respMessage = new MessageBuilder().withFromJid(message.getRecipientJids()[0])
                                .withRecipientJids(message.getFromJid())
                                .withBody(responseBody)
                                .build();
                SendResponse success = xmpp.sendMessage(respMessage);
                if (success.getStatusMap().get(message.getFromJid()) != SendResponse.Status.SUCCESS) {
                        LOG.warning("Failed to send message");
                }
        }

}
