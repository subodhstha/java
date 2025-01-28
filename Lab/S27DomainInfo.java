import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class S27DomainInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a domain name
        System.out.print("Enter a domain name (e.g., google.com): ");
        String domainName = scanner.nextLine();

        try {
            // Get the InetAddress object for the given domain name
            InetAddress inetAddress = InetAddress.getByName(domainName);

            // Display the hostname and IP address
            System.out.println("Host Name: " + inetAddress.getHostName());
            System.out.println("IP Address: " + inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            System.err.println("Error: Unable to resolve domain name. " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
