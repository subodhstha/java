// 22. Create a GUI with buttons labeled "Red," "Green," and "Blue." Change
// the background color of a panel based on the button clicked.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class S22ColorChanger {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Color Changer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create a panel whose background color will change
        JPanel colorPanel = new JPanel();

        // Create buttons for changing colors
        JButton redButton = new JButton("Red");
        JButton greenButton = new JButton("Green");
        JButton blueButton = new JButton("Blue");

        // Add ActionListeners to the buttons
        redButton.addActionListener(e -> colorPanel.setBackground(Color.RED));
        greenButton.addActionListener(e -> colorPanel.setBackground(Color.GREEN));
        blueButton.addActionListener(e -> colorPanel.setBackground(Color.BLUE));

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(redButton);
        buttonPanel.add(greenButton);
        buttonPanel.add(blueButton);

        // Add panels to the frame
        frame.add(colorPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);
    }
}
