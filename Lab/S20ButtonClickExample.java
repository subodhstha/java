// 20. Create a GUI with a button. When the button is clicked, display "Button
// Clicked!" in a JLabel.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class S20ButtonClickExample {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Button Click Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        // Create a JLabel
        JLabel label = new JLabel("Press the button to see a message.");

        // Create a JButton
        JButton button = new JButton("Click Me!");

        // Add an ActionListener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Button Clicked!");
            }
        });

        // Add components to the frame
        frame.add(label);
        frame.add(button);

        // Make the frame visible
        frame.setVisible(true);
    }
}
