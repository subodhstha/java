import java.sql.*;

public class S24PostgresCRUD {
    public static void main(String[] args) {
        // PostgreSQL connection details
        String url = "jdbc:postgresql://localhost:5432/lab"; // Replace with your database name
        String user = "postgres"; // Replace with your username
        String password = "user"; // Replace with your password

        // Connection object
        Connection connection = null;

        try {
            // Step 1: Establish a connection to the PostgreSQL database
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully.");

            // Step 2: Display database metadata
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());

            // Step 3: Create the Students table if it doesn't exist
            String createTableSQL = """
                    CREATE TABLE IF NOT EXISTS Students (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(50) NOT NULL,
                        grade CHAR(1) NOT NULL
                    );
                    """;
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTableSQL);
                System.out.println("Table 'Students' is ready.");
            }

            // Step 4: Insert sample data into the Students table
            String insertSQL = "INSERT INTO Students (name, grade) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                preparedStatement.setString(1, "Alice");
                preparedStatement.setString(2, "A");
                preparedStatement.executeUpdate();

                preparedStatement.setString(1, "Bob");
                preparedStatement.setString(2, "B");
                preparedStatement.executeUpdate();

                preparedStatement.setString(1, "Charlie");
                preparedStatement.setString(2, "A");
                preparedStatement.executeUpdate();

                System.out.println("Sample data inserted into the table.");
            }

            // Step 5: Query student details based on grade
            String querySQL = "SELECT * FROM Students WHERE grade = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(querySQL)) {
                preparedStatement.setString(1, "A"); // Retrieve students with grade A
                ResultSet resultSet = preparedStatement.executeQuery();

                System.out.println("Students with grade A:");
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name") + ", Grade: " + resultSet.getString("grade"));
                }
            }

            // Step 6: Update a student's grade
            String updateSQL = "UPDATE Students SET grade = ? WHERE name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
                preparedStatement.setString(1, "C");
                preparedStatement.setString(2, "Bob");
                int rowsUpdated = preparedStatement.executeUpdate();
                System.out.println(rowsUpdated + " row(s) updated.");
            }

            // Step 7: Delete a student from the table
            String deleteSQL = "DELETE FROM Students WHERE name = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
                preparedStatement.setString(1, "Charlie");
                int rowsDeleted = preparedStatement.executeUpdate();
                System.out.println(rowsDeleted + " row(s) deleted.");
            }

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Close the connection
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException ex) {
                System.err.println("Error closing connection: " + ex.getMessage());
            }
        }
    }
}
