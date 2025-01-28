import java.net.InetAddress;
import java.net.UnknownHostException;

public class S26LocalIPDetails {
    public static void main(String[] args) {
        try {
            // Get the local host information
            InetAddress localHost = InetAddress.getLocalHost();

            // Display the local IP address and hostname
            System.out.println("Host Name: " + localHost.getHostName());
            System.out.println("Local IP Address: " + localHost.getHostAddress());

            // Simulate a random port for demonstration (replace with actual port if needed)
            int port = 8080; // Common port for local servers
            System.out.println("Port Number: " + port);
        } catch (UnknownHostException e) {
            System.err.println("Unable to retrieve local IP address: " + e.getMessage());
        }
    }
}
