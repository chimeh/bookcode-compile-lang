package com.example.web;

import com.example.model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class CoffeeSelect extends HttpServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                        throws IOException, ServletException {
                            
        String c = request.getParameter("color");
        CoffeeExpert ce = new CoffeeExpert();
        List result = ce.getBrands(c);
        
        /*  
         * response.setContentType("text/html");
         * PrintWriter out = response.getWriter();
         * out.println("Coffee Selection Advice<br />");
         */
        
        /*
        Iterator it = result.iterator();
        while (it.hasNext()) {
            out.print("<br />try: " + it.next());
        }
        */
        
        /*
         * Add an attribute to the request object for the JSP to use. Notice
         * the JSP is looking for "styles"
         */
        request.setAttribute("styles", result);
        
        /*
         * Instantiate a request dispather for the JSP
         */
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        
        /*
         * Use the request dispather to ask the container to crank up the JSP,
         * sending it the request and response.
         */
        view.forward(request, response);
    }
}