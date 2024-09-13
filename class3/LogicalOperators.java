// Lab 5 - Logical Operators
import java.util.Scanner;
public class LogicalOperators {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number");
        int num1 = scanner.nextInt();
        System.out.println("Enter the second number");
        int num2 = scanner.nextInt();
        System.out.println("Enter the operator");
        String operator = scanner.next();
        boolean result = false;
        switch (operator) {
            case "&&":
                result = num1 > 0 && num2 > 0;
                break;
            case "||":
                result = num1 > 0 || num2 > 0;
                break;
            case "!":
                result = !(num1 > 0);
                break;
            default:
                System.out.println("Invalid operator");
        }
        System.out.println("The result is " + result);
    }
}
