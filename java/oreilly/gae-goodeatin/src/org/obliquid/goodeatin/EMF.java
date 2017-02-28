package org.obliquid.goodeatin;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Singleton class returning an EntityManagerFactory.
 * 
 * @author stivlo
 * 
 */
public class EMF {

        private static final EntityManagerFactory emfInstance = Persistence
                        .createEntityManagerFactory("transactions-optional");

        private EMF() {
        }

        public static EntityManagerFactory get() {
                return emfInstance;
        }

}
