package class1; /**
 * hello
 */
// Lab 1
import java.util.Scanner;

public class hello{
    public static void main(String[] args) {
        // System.out.println("hello world");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name");
        String name = scanner.nextLine();
        System.out.println("Enter the age");
        int age = scanner.nextInt();
        System.out.println("Hi! " + name + " your age is " + age);
        scanner.close();
    }
}