// Lab 2: Take data in runtime
import java.util.Scanner;

public class TakeDataInRuntime {
    public static void main(String[] args) {
        if (args.length > 0) {
            String name = args[0];
            System.out.println("Hi! " + name);
        } 
        else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Hi! " + name);
            scanner.close();
        }
    }
}