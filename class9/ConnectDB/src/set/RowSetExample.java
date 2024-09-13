package set;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class RowSetExample {
    public static void main(String[] args) {
        JdbcRowSet rowSet = null;
        try {
            // Create and configure JdbcRowSet instance
            rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:postgresql://localhost:5432/javadb");
            rowSet.setUsername("postgres");
            rowSet.setPassword("user");

            // Set the SQL query to execute
            rowSet.setCommand("SELECT id, name, age, grade FROM students");
            rowSet.execute();

            // Process the result
            while (rowSet.next()) {
                int id = rowSet.getInt("id");
                String name = rowSet.getString("name");
                int age = rowSet.getInt("age");
                String grade = rowSet.getString("grade");

                // Print the result
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Grade: " + grade);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the JdbcRowSet
            try {
                if (rowSet != null) rowSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
