package org.obliquid.goodeatin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet to show the form to create a new restaurant.
 * 
 * @author stivlo
 * 
 */
@SuppressWarnings("serial")
public class NewRestaurant extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
                        IOException {
                RequestDispatcher view = req.getRequestDispatcher("WEB-INF/jsp/newRestaurant.jsp");
                view.forward(req, resp);
        }

}
