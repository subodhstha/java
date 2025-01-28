import java.net.*;

public class UDPSquareServer {
    public static void main(String[] args) {
        int port = 12345; // Port number for the server to listen on

        try (DatagramSocket serverSocket = new DatagramSocket(port)) {
            System.out.println("UDP Server is running on port " + port + "...");

            byte[] receiveBuffer = new byte[1024];
            byte[] sendBuffer;

            while (true) {
                // Receive data from the client
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket);

                String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from client: " + receivedData);

                // Parse the received number and calculate its square
                try {
                    int number = Integer.parseInt(receivedData.trim());
                    int square = number * number;

                    // Send the square back to the client
                    String response = "Square: " + square;
                    sendBuffer = response.getBytes();
                    InetAddress clientAddress = receivePacket.getAddress();
                    int clientPort = receivePacket.getPort();

                    DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
                    serverSocket.send(sendPacket);

                    System.out.println("Sent to client: " + response);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number received: " + receivedData);
                }
            }
        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
