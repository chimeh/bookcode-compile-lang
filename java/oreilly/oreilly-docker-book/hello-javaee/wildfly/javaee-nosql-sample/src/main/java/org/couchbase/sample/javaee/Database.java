package org.couchbase.sample.javaee;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonLongDocument;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author Arun Gupta
 */
@Singleton
@Startup
public class Database {

    CouchbaseCluster cluster;
    Bucket bucket;

    @PostConstruct
    public void init() {
        if (!getBucket().exists("books_sequence")) {
            N1qlQuery query = N1qlQuery.simple("SELECT MAX(id) + 1 as counterInit FROM `books`");
            N1qlQueryResult result = bucket.query(query);
            long counterInit = 0;
            if (result.finalSuccess() && result.allRows().get(0).value().getLong("counterInit") != null) {
                counterInit = result.allRows().get(0).value().getLong("counterInit");
            }
            bucket.upsert(JsonLongDocument.create("books_sequence", counterInit));
        }
    }

    @PreDestroy
    public void stop() {
        bucket.close();
        cluster.disconnect();
    }

    public CouchbaseCluster getCluster() {
        if (null == cluster) {
            // Docker environment
            String couchbaseHost = System.getenv("COUCHBASE_URI");
            if (couchbaseHost == null) {
                System.out.println("Docker configuration not found, trying Kubernetes configuration ...");
                // Kubernetes environment
                couchbaseHost = System.getenv("COUCHBASE_SERVICE_SERVICE_HOST");
                if (couchbaseHost == null) {
                    System.out.println("Kubernetes configuration not found, using default value ...");
                    couchbaseHost = "localhost";
                } else {
                    System.out.println("Kubernetes configuration found");
                }
            }
            System.out.println("Couchbase Host: " + couchbaseHost);
            cluster = CouchbaseCluster.create(couchbaseHost);
        }
        return cluster;
    }

    public Bucket getBucket() {
        if (null == bucket) {
            bucket = getCluster().openBucket("books");
        }
        return bucket;
    }
}
