package StructuredQueryLanguage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class InsertExample {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javadb", "postgres", "user");
            String insertQuery = "INSERT INTO students (id,name, age, grade) VALUES(?,?,?,?)";
            pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, 7);
            pstmt.setString(2, "ram");
            pstmt.setInt(3, 6);
            pstmt.setString(4, "A");
            int rowInserted = pstmt.executeUpdate();
            if (rowInserted > 0)
            {
                System.out.println("Record inserted successfully" + rowInserted);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
