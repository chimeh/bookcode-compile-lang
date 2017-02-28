package org.obliquid.goodeatin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.memcache.Expiration;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;

@SuppressWarnings("serial")
public class GoodEatinServlet extends HttpServlet {

        private static Logger logger = Logger.getLogger(GoodEatinServlet.class.getName());

        /** Top restaurants Memcached key. */
        public static final String TOP_RESTAURANTS = "topRestaurants";

        @Override
        @SuppressWarnings("unchecked")
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException,
                        ServletException {
                List<Restaurant> restList = null;
                EntityManager em = EMF.get().createEntityManager();
                try {
                        MemcacheService memcache = MemcacheServiceFactory.getMemcacheService();
                        restList = (List<Restaurant>) memcache.get(TOP_RESTAURANTS);
                        if (restList != null) {
                                logger.info("CACHE HIT: Found the restaurant list");
                        } else {
                                //String gql = "SELECT r FROM Restaurant r " +
                                //                "WHERE name=\"Brett's House\" ORDER BY dateAdded DESC";
                                String gql = "SELECT r FROM Restaurant r ORDER BY dateAdded DESC";
                                Query query = em.createQuery(gql);
                                //instead of using setFirstResult(), for paging, figure the key of the last
                                //one and use WHERE, to find keys greater than it.
                                //query.setFirstResult(0);
                                //query.setMaxResults(3); //limit the max results
                                restList = query.getResultList();
                                //force fetching of all data, and put into a Serializable list
                                List<Restaurant> localList = new ArrayList<Restaurant>();
                                localList.addAll(restList);
                                memcache.put(TOP_RESTAURANTS, localList, Expiration.byDeltaSeconds(30));
                                logger.info("CACHE MISS: Had to fetch the restaurant list");
                        }
                        req.setAttribute("restaurants", restList);
                        //logger.fine("Restaurants: " + req.getAttribute("restaurants"));
                        RequestDispatcher view = req.getRequestDispatcher("WEB-INF/jsp/listView.jsp");
                        view.forward(req, resp);
                } finally {
                        em.close();
                }
        }

}
