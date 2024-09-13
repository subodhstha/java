import java.sql.*;
import java.sql.SQLException;
public class ConnectDb {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javadb", "postgres","user");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next())
            {
                System.out.println("id:" + rs.getInt("id"));
                System.out.println("name" + rs.getString("name"));
                System.out.println("age" + rs.getInt("age"));
                System.out.println("grade" + rs.getString("grade"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                if (rs != null) rs.close();;
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
