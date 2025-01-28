import java.net.*;
import java.util.Scanner;

public class UDPSquareClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Server's IP address
        int serverPort = 12345;             // Server's port number

        try (DatagramSocket clientSocket = new DatagramSocket();
             Scanner scanner = new Scanner(System.in)) {

            InetAddress serverInetAddress = InetAddress.getByName(serverAddress);

            System.out.print("Enter a number to send to the server: ");
            String number = scanner.nextLine();

            // Send the number to the server
            byte[] sendBuffer = number.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverInetAddress, serverPort);
            clientSocket.send(sendPacket);

            // Receive the response from the server
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);

            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Response from server: " + response);

        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
