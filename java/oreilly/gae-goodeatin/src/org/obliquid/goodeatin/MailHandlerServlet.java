package org.obliquid.goodeatin;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MailHandlerServlet extends HttpServlet {

        private static final Logger LOG = Logger.getLogger(MailHandlerServlet.class.getName());

        @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp) {
                Session session = Session.getDefaultInstance(new Properties(), null);
                try {
                        MimeMessage message = new MimeMessage(session, req.getInputStream());
                        String content;
                        if (message.getContent() instanceof String) {
                                content = (String) message.getContent();
                        } else {
                                MimeMultipart mmp = (MimeMultipart) message.getContent();
                                content = (String) mmp.getBodyPart(0).getContent();
                        }
                        String url = "/commentMaker?restaurantId="
                                        + Long.parseLong(message.getSubject())
                                        + "&comment="
                                        + URLEncoder.encode(content, "UTF-8");
                        LOG.fine("URL: " + url);
                        //RequestDispatcher reqDisp = req.getRequestDispatcher(url);
                        //reqDisp.forward(req, resp);
                } catch (MessagingException ex) {
                        ex.printStackTrace();
                } catch (IOException ex) {
                        ex.printStackTrace();
                        //} catch (ServletException ex) {
                        //        ex.printStackTrace();
                }
        }

}
