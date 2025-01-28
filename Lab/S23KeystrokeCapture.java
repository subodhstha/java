// 23. Write a program to capture and display keystrokes in a JTextArea.
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class S23KeystrokeCapture {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Keystroke Capture Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a JTextArea
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false); // Make it read-only
        textArea.setText("Start typing to capture keystrokes...\n");
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add a KeyAdapter to capture keystrokes
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String keyText = KeyEvent.getKeyText(e.getKeyCode());
                textArea.append("Key Pressed: " + keyText + "\n");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String keyText = KeyEvent.getKeyText(e.getKeyCode());
                textArea.append("Key Released: " + keyText + "\n");
            }
        });

        // Add the scroll pane to the frame
        frame.add(scrollPane);

        // Make the frame visible
        frame.setVisible(true);
    }
}
