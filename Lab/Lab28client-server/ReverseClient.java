import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ReverseClient {
    public static void main(String[] args) {
        String host = "localhost"; // Server's hostname or IP address
        int port = 12345;          // Server's port number

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to the server!");

            // Send a message to the server
            System.out.print("Enter a message to send to the server: ");
            String message = scanner.nextLine();
            out.println(message);

            // Read the server's response
            String response = in.readLine();
            System.out.println("Server responded with: " + response);

        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
