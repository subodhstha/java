import java.io.*;
import java.net.*;

public class ReverseServer {
    public static void main(String[] args) {
        int port = 12345; // Port number for the server to listen on

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port + "...");

            // Wait for a client connection
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("Client connected: " + clientSocket.getInetAddress());

                    // Read the message from the client
                    String message = in.readLine();
                    System.out.println("Received from client: " + message);

                    // Reverse the message
                    String reversedMessage = new StringBuilder(message).reverse().toString();

                    // Send the reversed message back to the client
                    out.println(reversedMessage);
                    System.out.println("Sent to client: " + reversedMessage);
                } catch (IOException e) {
                    System.err.println("Error handling client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
