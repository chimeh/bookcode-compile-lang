## Configuring and Starting HSQLDB

1. to start HSQLDB, cd into your HSQLDB installation directory and run the following java command
    * ```java -classpath lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:hsqldb/oreilly --dbname.0 testdb```
2. schema.sql will automatically be loaded by spring boot once the oauth-server is started