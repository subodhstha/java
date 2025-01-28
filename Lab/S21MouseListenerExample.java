// 21. Implement a mouse listener using an adapter class to handle mouse events like
// mouseClicked() and mouseEntered().import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class S21MouseListenerExample {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Mouse Listener Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        // Create a JLabel to display mouse events
        JLabel label = new JLabel("Perform mouse actions!");
        label.setFont(new Font("Arial", Font.PLAIN, 16));

        // Add a MouseAdapter to handle mouse events
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse Clicked!");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("Mouse Entered!");
            }
        });

        // Add the label to the frame
        frame.add(label);

        // Make the frame visible
        frame.setVisible(true);
    }
}
