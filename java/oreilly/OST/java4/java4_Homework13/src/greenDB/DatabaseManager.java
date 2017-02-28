package greenDB;
                
import java.sql.*;
                
public class DatabaseManager {
    private Connection conn;  
    private Statement stmt;
    private ResultSet rset;
                    
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
                    
    private String [] initListingsTable() {
        // Executable SQL commands for creating Listings table 
        // inserting initial names and phone numbers.
        System.out.println("Initializing table");
        String[]  SQL = {
            "create table Listings (" +
            "PRI_KEY    MEDIUMINT NOT NULL AUTO_INCREMENT," +
            "LAST_NAME  varchar (16)," +
            "FIRST_NAME varchar (16)," +
            "AREA_CODE  varchar(3)," +
            "PREFIX     varchar(3)," +
            "SUFFIX     varchar(4)," +
            "PRIMARY KEY (PRI_KEY))",
            "insert into Listings  values (default, 'ANDERSON', 'JOHN',  '314', '825', '1695')",
            "insert into Listings  values (default, 'CABLES',   'WALLY', '212', '434', '9685')",
            "insert into Listings  values (default, 'FRY',      'EDGAR', '415', '542', '5885')",
            "insert into Listings  values (default, 'MARTIN',   'EDGAR', '665', '662', '9001')",
            "insert into Listings  values (default, 'TUCKER',   'JOHN',  '707', '696', '8541')",
        };
        return SQL;
    }
                    
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
                    
    public void doGetQuery(String query) {  // rather than the "getEntries" of the previous example
        try {
            rset = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
                    
    public void doInsertQuery(String query) {   // rather than the hard-coded "addEntry" of the previous example
        try {  
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
                    
    public ResultSet getResultSet() {  // a new method that will let the GUI get the resultSet to manipulate it
        return rset;
    } 
                    
    public void close(boolean remove){  // closes all open connections                                             
        try {
            if (remove) { 
                stmt.execute ("drop table Listings;");                                 
                stmt.close();
                conn.close();
            }
            
            if(!remove) {
              stmt.close();
              conn.close();
            }
        }
        catch ( SQLException e ) {
            System.out.println ("\n*** SQLException caught ***\n");
            e.printStackTrace();
        }
    }
    
}
