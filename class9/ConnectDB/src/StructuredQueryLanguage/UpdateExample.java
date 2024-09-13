package StructuredQueryLanguage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class UpdateExample {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // Establish a connection to the database
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javadb", "postgres", "user");

            // Ensure the connection was successful
            if (conn != null) {
                // SQL Update query with placeholders
                String updateQuery = "UPDATE students SET name = ?, age = ?, grade = ? WHERE id = ?";

                // Prepare the statement
                pstmt = conn.prepareStatement(updateQuery);

                // Set the values for each placeholder
                pstmt.setString(1, "sam");
                pstmt.setInt(2, 25);
                pstmt.setString(3, "B");
                pstmt.setInt(4, 4);

                // Execute the update query
                int rowUpdate = pstmt.executeUpdate();

                // Check if any rows were updated
                if (rowUpdate > 0) {
                    System.out.println("Record updated successfully. Rows affected: " + rowUpdate);
                }
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}