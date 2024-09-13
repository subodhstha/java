import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDb {
    public static void main(String[] args) {
        // Load the PostgreSQL JDBC driver
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return; // If the driver class is not found, exit the program
        }

        // Initialize connection, statement, and result set
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Establish the connection
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javadb", "postgres", "user");
            // Create a statement
            stmt = conn.createStatement();
            // Execute a query
            rs = stmt.executeQuery("SELECT * FROM students");

            // Process the result set
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("name: " + rs.getString("name"));
                System.out.println("age: " + rs.getInt("age"));
                System.out.println("grade: " + rs.getString("grade"));
            }
        } catch (SQLException e) {
            // Handle SQL exceptions (e.g., database connection errors)
            e.printStackTrace();
        } finally {
            // Close resources in the reverse order of their creation
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}