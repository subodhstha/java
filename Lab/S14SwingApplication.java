// 14. Create a Swing application with components like JButton, JLabel, and
// JTextField added to a JPanel, which is then added to a JFrame.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class S14SwingApplication {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Swing Application Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        // Create a panel
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Add components to the panel
        JLabel label = new JLabel("Enter your name:");
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Submit");
        JLabel outputLabel = new JLabel();

        // Add components to the panel
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        panel.add(outputLabel);

        // Add the panel to the frame
        frame.add(panel, BorderLayout.CENTER);

        // Add button click event listener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                outputLabel.setText("Hello, " + name + "!");
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
