package org.obliquid.goodeatin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class CommentMaker extends HttpServlet {

        @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
                EntityManager em = EMF.get().createEntityManager();
                EntityTransaction tx = em.getTransaction();
                try {
                        tx.begin();
                        Restaurant r = em.find(Restaurant.class,
                                        Long.parseLong(req.getParameter("restaurantId")));
                        if (r != null) {
                                Comment c = new Comment();
                                c.setCommentText(req.getParameter("comment"));
                                r.getComments().add(c); //this is really bad style
                                em.persist(r);
                                User commentSubmitter = UserServiceFactory.getUserService().getCurrentUser();
                                emailRestaurantSubmitter(r, c, commentSubmitter);
                        }
                        tx.commit();
                } finally {
                        if (tx.isActive()) {
                                tx.rollback();
                        }
                }
                //resp.sendRedirect("/goodEatin"); //we are now calling from Task Queue
        }

        private void emailRestaurantSubmitter(Restaurant r, Comment c, User commentSubmitter) {
                if (r.getSubmitter() == null) {
                        return; //ignore restaurants without submitters
                }
                Session session = Session.getDefaultInstance(new Properties(), null);
                StringBuilder body = new StringBuilder("Hello ");
                body.append(r.getSubmitter().getNickname()).append(",\r\nA new comment was added ");
                if (commentSubmitter != null) {
                        body.append("by ").append(commentSubmitter.getNickname());
                }
                body.append(" to \"").append(r.getName()).append("\":\r\n\r\n").append(c.getCommentText());
                try {
                        Message msg = new MimeMessage(session);
                        //can only set some of the headers
                        //from must be a registered app administrator or the currently authenticated user
                        msg.setFrom(new InternetAddress("stivlo@gmail.com", "Good Eatin'"));
                        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(r.getSubmitter()
                                        .getEmail(), r.getSubmitter().getNickname()));
                        msg.setSubject("New comment on your submission");
                        msg.setText(body.toString());
                        Transport.send(msg);
                } catch (UnsupportedEncodingException ex) {
                        ex.printStackTrace();
                } catch (MessagingException ex) {
                        ex.printStackTrace();
                }
        }

}
