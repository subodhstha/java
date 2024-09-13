package StructuredQueryLanguage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class DeleteExample {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javadb", "postgres", "user");
            String deleteQuery = "DELETE FROM students WHERE id = ?";
            pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setInt(1, 1);
            int rowDelete = pstmt.executeUpdate();
            if (rowDelete > 0) {
                System.out.println("Record deleted successfully" + rowDelete);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
