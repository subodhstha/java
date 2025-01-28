// 19. Create a GUI with JInternalFrame and a table (JTable) to display a list of
// students with their names and grades.
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class S19StudentTableGUI {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Student Grades");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Create a desktop pane to hold the internal frame
        JDesktopPane desktopPane = new JDesktopPane();

        // Create an internal frame
        JInternalFrame internalFrame = new JInternalFrame("Student List", true, true, true, true);
        internalFrame.setSize(500, 300);
        internalFrame.setLayout(new BorderLayout());

        // Create table data and column names
        String[] columnNames = {"Name", "Grade"};
        Object[][] data = {
            {"Alice", "A"},
            {"Bob", "B"},
            {"Charlie", "A"},
            {"Diana", "C"},
            {"Eve", "B"}
        };

        // Create a table model and JTable
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(tableModel);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        internalFrame.add(scrollPane, BorderLayout.CENTER);

        // Add the internal frame to the desktop pane
        desktopPane.add(internalFrame);

        // Add the desktop pane to the main frame
        frame.add(desktopPane, BorderLayout.CENTER);

        // Make the internal frame visible
        internalFrame.setVisible(true);

        // Make the main frame visible
        frame.setVisible(true);
    }
}
