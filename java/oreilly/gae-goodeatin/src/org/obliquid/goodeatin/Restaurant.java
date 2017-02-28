package org.obliquid.goodeatin;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;

@Entity
public class Restaurant implements Serializable {

        /**
         * Universal serial identifier.
         */
        private static final long serialVersionUID = 1L;

        private Key id;

        private String name;

        private String description;

        private Date dateAdded;

        private String address;

        private List<Comment> comments;

        private User submitter;

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
         * @return the name
         */
        public String getName() {
                return name;
        }

        /**
         * @param name
         *                the name to set
         */
        public void setName(String name) {
                this.name = name;
        }

        /**
         * @return the description
         */
        public String getDescription() {
                return description;
        }

        /**
         * @param description
         *                the description to set
         */
        public void setDescription(String description) {
                this.description = description;
        }

        /**
         * @return the dateAdded
         */
        public Date getDateAdded() {
                return dateAdded;
        }

        /**
         * @param dateAdded
         *                the dateAdded to set
         */
        public void setDateAdded(Date dateAdded) {
                this.dateAdded = dateAdded;
        }

        /**
         * @return the address
         */
        public String getAddress() {
                return address;
        }

        /**
         * @param address
         *                the address to set
         */
        public void setAddress(String address) {
                this.address = address;
        }

        @Override
        public String toString() {
                return getName();
        }

        /**
         * mappedBy tells the property in Comment used to track this
         * relationship.
         * 
         * @return the comments
         */
        @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant", fetch = FetchType.LAZY)
        public List<Comment> getComments() {
                return comments;
        }

        /**
         * @param comments
         *                the comments to set
         */
        public void setComments(List<Comment> comments) {
                this.comments = comments;
        }

        /**
         * @return the submitter
         */
        public User getSubmitter() {
                return submitter;
        }

        /**
         * @param submitter
         *                the submitter to set
         */
        public void setSubmitter(User submitter) {
                this.submitter = submitter;
        }

}
