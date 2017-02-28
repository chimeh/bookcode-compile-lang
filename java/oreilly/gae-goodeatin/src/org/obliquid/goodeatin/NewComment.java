package org.obliquid.goodeatin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class NewComment extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
                        IOException {
                RequestDispatcher view = req.getRequestDispatcher("WEB-INF/jsp/newComment.jsp");
                view.forward(req, resp);
        }

}
