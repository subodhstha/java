// 16. Create a menu bar with menus for "File" and "Edit." Add menu items such
// as "Open," "Save," and "Exit." Enable and disable them programmatically.ch
import javax.swing.*;
import java.awt.event.*;

public class S16MenuBarExample {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Menu Bar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create "File" menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add menu items to "File" menu
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator(); // Add a separator
        fileMenu.add(exitItem);

        // Create "Edit" menu
        JMenu editMenu = new JMenu("Edit");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");

        // Add menu items to "Edit" menu
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);

        // Programmatically disable the "Save" menu item
        saveItem.setEnabled(false);

        // Add action listeners for menu items
        openItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Open selected"));
        saveItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Save selected"));
        exitItem.addActionListener(e -> System.exit(0));

        cutItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Cut selected"));
        copyItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Copy selected"));
        pasteItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Paste selected"));

        // Button to enable/disable "Save" menu item
        JButton toggleSaveButton = new JButton("Toggle Save Item");
        toggleSaveButton.addActionListener(e -> saveItem.setEnabled(!saveItem.isEnabled()));

        // Add button to frame
        frame.add(toggleSaveButton);
        frame.setLayout(new java.awt.FlowLayout());

        // Make the frame visible
        frame.setVisible(true);
    }
}