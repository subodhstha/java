import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class S13SwingExample {
    public static void main(String[] args) {
        // Create a frame
        JFrame frame = new JFrame("Swing Example");

        // Create components
        JLabel label = new JLabel("Enter your name:");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Submit");
        JLabel outputLabel = new JLabel();

        // Set layout
        frame.setLayout(new FlowLayout());

        // Add components to the frame
        frame.add(label);
        frame.add(textField);
        frame.add(button);
        frame.add(outputLabel);

        // Add button click event
        button.addActionListener(e -> {
            String name = textField.getText();
            outputLabel.setText("Hello, " + name + "!");
        });

        // Close the frame on close button click
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set frame size and make it visible
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
