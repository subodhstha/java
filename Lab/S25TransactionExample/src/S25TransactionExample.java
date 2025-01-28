import java.sql.*;

public class S25TransactionExample {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:postgresql://localhost:5432/lab"; // Replace with your database name
        String user = "postgres"; // Replace with your username
        String password = "user"; // Replace with your password

        Connection connection = null;

        try {
            // Step 1: Establish a connection to the database
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully.");

            // Step 2: Disable auto-commit mode to manage transactions manually
            connection.setAutoCommit(false);

            // Step 3: Perform multiple SQL statements within the transaction
            try (Statement statement = connection.createStatement()) {
                // Insert into Students table
                String insertSQL1 = "INSERT INTO Students (name, grade) VALUES ('David', 'B')";
                String insertSQL2 = "INSERT INTO Students (name, grade) VALUES ('Eva', 'A')";
                statement.executeUpdate(insertSQL1);
                System.out.println("Inserted: David, Grade: B");
                statement.executeUpdate(insertSQL2);
                System.out.println("Inserted: Eva, Grade: A");

                // Introduce an intentional error (invalid column name)
                String validSQL = "INSERT INTO Students (name, grade) VALUES ('Valid', 'A')";
                statement.executeUpdate(validSQL);

                // Commit the transaction if everything succeeds
                connection.commit();
                System.out.println("Transaction committed successfully.");
            } catch (SQLException e) {
                // Rollback the transaction in case of any error
                System.err.println("Error during transaction: " + e.getMessage());
                if (connection != null) {
                    connection.rollback();
                    System.out.println("Transaction rolled back.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        } finally {
            // Close the connection
            try {
                if (connection != null) {
                    connection.setAutoCommit(true); // Reset auto-commit to default
                    connection.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException ex) {
                System.err.println("Error closing connection: " + ex.getMessage());
            }
        }
    }
}
