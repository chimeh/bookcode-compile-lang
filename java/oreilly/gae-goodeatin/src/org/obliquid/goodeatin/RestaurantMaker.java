package org.obliquid.goodeatin;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.google.appengine.api.users.UserServiceFactory;

/**
 * Save the list of Restaurants into the data store. Every top level entity has
 * to be saved in its own transaction.
 */
public class RestaurantMaker extends HttpServlet {

        private static final long serialVersionUID = 1L;

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                        throws ServletException, IOException {
                EntityManager em = EMF.get().createEntityManager();
                try {
                        EntityTransaction tx = em.getTransaction();
                        tx.begin();
                        Restaurant r = new Restaurant();
                        r.setName("Brett's House");
                        r.setDescription("Great food, pretty good company... sometimes.");
                        r.setAddress("123 South St.");
                        r.setDateAdded(new Date());
                        Comment comment2 = new Comment();
                        comment2.setCommentText("Here is our second comment");
                        r.setComments(Arrays.asList(comment2));
                        em.persist(r);
                        tx.commit();

                        tx = em.getTransaction();
                        tx.begin();
                        r = new Restaurant();
                        r.setName("Bob's BBQ");
                        r.setDescription("This place rocks!");
                        r.setAddress("12 Diamond St.");
                        r.setDateAdded(new Date());
                        Comment comment3 = new Comment();
                        comment3.setCommentText("Here is our third comment");
                        r.setComments(Arrays.asList(comment3));
                        Comment comment4 = new Comment();
                        comment4.setCommentText("Here is our fourth comment");
                        r.setComments(Arrays.asList(comment3, comment4));
                        em.persist(r);
                        tx.commit();

                        tx = em.getTransaction();
                        tx.begin();
                        r = new Restaurant();
                        r.setName("Potato House");
                        r.setDescription("This place has the biggest potatoes I've ever seen. Seriously.");
                        r.setAddress("8 Tropical St.");
                        r.setDateAdded(new Date());
                        Comment comment5 = new Comment();
                        comment5.setCommentText("Here is our fifth comment");
                        r.setComments(Arrays.asList(comment5));
                        em.persist(r);
                        tx.commit();
                } finally {
                        em.close();
                }
                response.getWriter().print("<b>Done...</b>");
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                        throws ServletException, IOException {
                EntityManager em = EMF.get().createEntityManager();
                try {
                        Restaurant restaurant = new Restaurant();
                        restaurant.setName(req.getParameter("name"));
                        restaurant.setDescription(req.getParameter("description"));
                        restaurant.setAddress(req.getParameter("address"));
                        restaurant.setDateAdded(new Date());
                        restaurant.setSubmitter(UserServiceFactory.getUserService().getCurrentUser());
                        em.persist(restaurant);
                        MemcacheService memcache = MemcacheServiceFactory.getMemcacheService();
                        memcache.delete(GoodEatinServlet.TOP_RESTAURANTS);
                        resp.sendRedirect("goodEatin");
                } finally {
                        em.close();
                }
        }

}
