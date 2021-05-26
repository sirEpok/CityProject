import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2JDBCInsertDemo {
    static final String JDBC_DRIVER = "H2.JDBC.Driver(ver. 1.4.196 (2017-06-10), JDBC4.0)";
    static final String DB_URL = "jdbc:h2:mem:test";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Connected database successfully...");

            // STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "INSERT INTO CITY " + "VALUES (100, 'Perm', 'Perm krai', 'Privol', 18 , 1923)";

            stmt.executeUpdate(sql);
            sql = "INSERT INTO CITY " + "VALUES (100, 'Perm', 'Perm krai', 'Privol', 18 , 1953)";

            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        System.out.println("Goodbye!");
    }
}
