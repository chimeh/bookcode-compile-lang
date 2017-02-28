package org.obliquid.goodeatin;

import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultTaskQueueServlet extends HttpServlet {

        private static final Logger LOG = Logger.getLogger(DefaultTaskQueueServlet.class.getName());

        @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp) {
                LOG.info("DefaultTaskQueue Servlet called!");
        }

}
