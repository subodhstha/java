import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTransactionExample {
    public static void main(String[] args) {
        final String URL = "jdbc:postgresql://localhost:5432/javadb";
        final String USER = "postgres";
        final String PASSWORD = "user";

        Connection connection = null;
        PreparedStatement pstm1 = null;
        PreparedStatement pstm2 = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);

            System.out.println("Connection established successfully.");

            String sql1 = "UPDATE accounts SET balance = balance - 500 WHERE account_id = ?";
            pstm1 = connection.prepareStatement(sql1);
            pstm1.setInt(1, 1001);
            System.out.println("Executing query: " + sql1);
            pstm1.executeUpdate();

            String sql2 = "UPDATE accounts SET balance = balance + 500 WHERE account_id = ?";
            pstm2 = connection.prepareStatement(sql2);
            pstm2.setInt(1, 1002);
            System.out.println("Executing query: " + sql2);
            pstm2.executeUpdate();

            connection.commit();
            System.out.println("Transaction committed successfully");

        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                    System.out.println("Transaction rolled back");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (pstm1 != null) pstm1.close();
                if (pstm2 != null) pstm2.close();
                if (connection != null) connection.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}