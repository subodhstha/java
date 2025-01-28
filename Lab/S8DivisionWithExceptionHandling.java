// 8. Write a program that prompts the user to enter two integers and performs
// division. Handle exceptions for invalid inputs (e.g., non-numeric input)
// and division by zero.
import java.util.Scanner;

public class S8DivisionWithExceptionHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt the user to enter two integers
            System.out.print("Enter the first integer: ");
            float num1 = scanner.nextInt();

            System.out.print("Enter the second integer: ");
            float num2 = scanner.nextInt();

            // Perform division
            float result = num1 / num2;
            System.out.println("Result of division: " + result);

        } catch (ArithmeticException e) {
            // Handle division by zero
            System.out.println("Error: Division by zero is not allowed.");
        } catch (java.util.InputMismatchException e) {
            // Handle invalid (non-numeric) input
            System.out.println("Error: Please enter valid integers.");
        } finally {
            // Close the scanner
            scanner.close();
            System.out.println("Program execution completed.");
        }
    }
}
