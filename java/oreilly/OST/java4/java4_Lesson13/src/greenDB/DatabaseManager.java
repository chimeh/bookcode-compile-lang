package greenDB;
                
import java.sql.*;
                
public class DatabaseManager {
    /** A connection to DatabaseManager */
    private Connection conn;  
    /** An executable SQL statement */
    private Statement stmt;
    /** The result of an executed SQL statement */
    private ResultSet rset;
    
    /* DatabaseManager Constructor */
    /**
     * This constructor connects to the MySQL database at jdbc:mysql:sql.useractive.com:3306.
     * It creates instances of Statement and ResultSet that will be used by the other methods
     * in the class. It also checks to see if the Listings table already exists. If it does, it
     * simply returns to the caller. Otherwise, it instanties the method to create a table
     * called Listings, and then populates the table.
     * <pre>
     * PRE:   MySQL server is available and account for user has been established.
     *        The MySQL driver is installed on the client workstation and its location
     *        has been defined in CLASSPATH (or for Eclipse, in its Referenced Libraries).
     *        Username and password not null.
     * POST:  A connection is made and the Listings table is either created and initialized on
     *        jdbc:mysql://sql.useractive.com:3306, or the already existing Listings table is
     *        identified.
     * </pre>
     * @param username
     * @param password
     */
                    
    public DatabaseManager (String username, String password) {  // the constructor for the database manager
        // Connect to database and execute the SQL commands for creating and initializing the Listings table.
        try {
            Class.forName ("com.mysql.jdbc.Driver");  // Load the MySQL JDBC driver
        }
        catch (ClassNotFoundException e) {
            System.out.println("Failed to load JDBC/ODBC driver.");
            e.printStackTrace();
            return;
        }
                    
        try {                   
            // Connect to the database.
            // Give the whole URL as a parameter rather than using a variable
            conn = DriverManager.getConnection("jdbc:mysql://sql.useractive.com:3306/" + username, username, password);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);   // Create a Statement
            // Execute the creation and initialization of table query 
            DatabaseMetaData aboutDB = conn.getMetaData(); 
            String [] tableType = {"TABLE"};
            ResultSet rs = aboutDB.getTables(null, null, "Listings",  tableType);   
            if (!inspectForTable (rs, "Listings")) {     // Find out if the table is already there
                // there is no table--make it from the initialization listing
                String [] SQL = initListingsTable();     // code for this method is below
                for (int i=0; i < SQL.length; i++) 
                {
                    stmt.execute(SQL[i]);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /*initListingsTable */
    /**
     * Creates the Listings table and initializes it with some records. This method connects
     * to the MySQL database at jdbc:mysql://sql.useractive.com:3306. It then creates a table
     * called Listings and initializes the table with some arbitrary records.
     * <pre>
     * PRE: True
     * POST: SQL String is created for the initial population of a table named Listings.
     * </pre>
     * @return
     */
                    
    private String [] initListingsTable() {
        // Executable SQL commands for creating Listings table 
        // inserting initial names and phone numbers.
        String[]  SQL = {
            "create table Listings (" +
            "LAST_NAME  varchar (16)," +
            "FIRST_NAME varchar (16)," +
            "AREA_CODE  varchar(3)," +
            "PREFIX     varchar(3)," +
            "SUFFIX     varchar(4))",
            "insert into Listings values ('ANDERSON', 'JOHN',  '314', '825', '1695')",
            "insert into Listings values ('CABLES',   'WALLY', '212', '434', '9685')",
            "insert into Listings values ('FRY',      'EDGAR', '415', '542', '5885')",
            "insert into Listings values ('MARTIN',   'EDGAR', '665', '662', '9001')",
            "insert into Listings values ('TUCKER',   'JOHN',  '707', '696', '8541')",
        };
        return SQL;
    }
    
    /*inspectForTable */
    /**
     * Determines if a table exists in the db.
     * <pre>
     * PRE:  Connection to database has been established. rs is not null.
     * POST: Table has not been changed, but its presence is verified(or not).
     * </pre>
     * @param rs ResultSet from DatabaseMetaData query about existing Tables
     * @param tableName String identifying the table in question
     * @return
     * @throws SQLException
     */
                    
    private boolean inspectForTable (ResultSet rs, String tableName)  throws SQLException {  // exception will be caught when method is used
        int i;
        ResultSetMetaData rsmd = rs.getMetaData ();  // Get the ResultSetMetaData to use for the column headings
        int numCols = rsmd.getColumnCount ();        // Get the number of columns in the result set
                    
        boolean more = rs.next ();
        while (more) {                               // Get each row, fetching until end of the result set
            for (i=1; i<=numCols; i++) { 
                if (rsmd.getColumnLabel(i) == "TABLE_NAME")   // Loop through each row, getting the column data looking for Tables
                    if  (rs.getString(i).equals(tableName))   // If the column is the TABLE_NAME, is it the one we are looking for?
                    {
                        System.out.println("Found one that equals " + rs.getString(i));
                        return true;
                    }
            }
            System.out.println("");
            more = rs.next ();              // Fetch the next result set row
        }
        return false;
    }
    
    /* doGetQuery */
    /**
     * Executes the select query specified.
     * <pre>
     * PRE:   Connection to database has been established. Query is assigned and is a simple
     *        select statement against the Listings table.
     * POST:  The query is executed.
     * </pre>
     * @param query a simple select query against the Listings table
     */
                    
    public void doGetQuery(String query) {  // rather than the "getEntries" of the previous example
        try {
            rset = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /* doInsertQuery */
    /**
     * Executes an insert statement, specified by query.
     * <pre>
     * PRE:  Connection to database has been established. Query is assigned and is a simple
     *       insert statement into the Listings table.
     * POST: The query is executed.
     * </pre>
     * @param query a simple insert query into the Listings table
     */             
    public void doInsertQuery(String query) {   // rather than the hard-coded "addEntry" of the previous example
        try {  
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /* getResultSet */
    /**
     * Returns the current value of the ResultSet instance
     * <pre>
     * PRE:  True
     * POST: ResultSet instance value is returned, its value remains the same as upon entry.
     * </pre>
     */
    public ResultSet getResultSet() {  // a new method that will let the GUI get the resultSet to manipulate it
        return rset;
    } 
    
    /* close */
    /**
     * Closes opened Statements and the Connection.
     * <pre>
     * PRE:  Connection to database has been established. Statement has been created. Listings is a table in the db
     * POST: If remove is true, table Listings is dropped, otherwise it is preserved.  Open Connection and Statement are closed
     * </pre>
     * @param remove boolean to specify if the table Listings should be dropped or not.
     */                    
    public void close(boolean remove){  // closes all open connections                                             
        try {
            if (remove) 
                stmt.execute ("drop table Listings;");                                 
            stmt.close();
            conn.close();
        }
        catch ( SQLException e ) {
            System.out.println ("\n*** SQLException caught ***\n");
            e.printStackTrace();
        }
    }
}
