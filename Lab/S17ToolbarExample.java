import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class S17ToolbarExample {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Toolbar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create the toolbar
        JToolBar toolBar = new JToolBar();

        // Create buttons for the toolbar
        JButton newButton = new JButton("New");
        newButton.setToolTipText("Create a new file");
        newButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "New action triggered"));

        JButton openButton = new JButton("Open");
        openButton.setToolTipText("Open an existing file");
        openButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Open action triggered"));

        JButton saveButton = new JButton("Save");
        saveButton.setToolTipText("Save the current file");
        saveButton.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Save action triggered"));

        // Add buttons to the toolbar
        toolBar.add(newButton);
        toolBar.add(openButton);
        toolBar.add(saveButton);

        // Add the toolbar to the frame
        frame.add(toolBar, BorderLayout.NORTH);

        // Set frame visibility
        frame.setVisible(true);
    }
}
