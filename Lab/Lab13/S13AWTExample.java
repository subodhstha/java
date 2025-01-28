import java.awt.*;
import java.awt.event.*;

public class S13AWTExample {
    public static void main(String[] args) {
        // Create a frame
        Frame frame = new Frame("AWT Example");

        // Create components
        Label label = new Label("Enter your name:");
        TextField textField = new TextField(20);
        Button button = new Button("Submit");
        Label outputLabel = new Label();

        // Set layout
        frame.setLayout(new FlowLayout());

        // Add components to the frame
        frame.add(label);
        frame.add(textField);
        frame.add(button);
        frame.add(outputLabel);

        // Add button click event
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                outputLabel.setText("Hello, " + name + "!");
            }
        });

        // Close the frame on close button click
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        // Set frame size and make it visible
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
