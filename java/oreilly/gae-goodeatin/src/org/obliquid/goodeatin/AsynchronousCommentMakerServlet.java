package org.obliquid.goodeatin;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;
import com.google.appengine.api.taskqueue.TaskOptions.Method;

@SuppressWarnings("serial")
public class AsynchronousCommentMakerServlet extends HttpServlet {

        private static final Logger LOG = Logger.getLogger(AsynchronousCommentMakerServlet.class.getName());

        @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
                LOG.info("Queueing comment addition for restaurant id: " + req.getParameter("restaurantId"));
                Queue queue = QueueFactory.getDefaultQueue();
                queue.add(TaskOptions.Builder.withUrl("/commentMaker")
                                .param("restaurantId", req.getParameter("restaurantId"))
                                .param("comment", req.getParameter("comment"))
                                .method(Method.POST)
                                .countdownMillis(10000)
                                );
                resp.sendRedirect("/");
        }

}
