package org.obliquid.goodeatin;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.appengine.api.datastore.Key;

@Entity
public class Comment implements Serializable {

        /**
         * Universal Serial Identifier.
         */
        private static final long serialVersionUID = 1L;

        private Key id;
        private String commentText;

        private Restaurant restaurant;

        /**
         * @return the id
         */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public Key getId() {
                return id;
        }

        /**
         * @param id
         *                the id to set
         */
        public void setId(Key id) {
                this.id = id;
        }

        /**
         * @return the commentText
         */
        public String getCommentText() {
                return commentText;
        }

        /**
         * @param commentText
         *                the commentText to set
         */
        public void setCommentText(String commentText) {
                this.commentText = commentText;
        }

        /**
         * Google App Engine does not even support EAGER, which by the way is
         * the default and will emit a WARNING if fetch is EAGER.
         * 
         * @return the restaurant
         */
        @ManyToOne(fetch = FetchType.LAZY)
        public Restaurant getRestaurant() {
                return restaurant;
        }

        /**
         * @param restaurant
         *                the restaurant to set
         */
        public void setRestaurant(Restaurant restaurant) {
                this.restaurant = restaurant;
        }

}
