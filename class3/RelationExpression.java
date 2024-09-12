// lab 4
import java.util.Scanner;

public class RelationExpression {
    public static void main(String[] args)
    {
        // int a = 10;
        // int b = 20;
        // System.out.println("a == b = " + (a == b) );
        // System.out.println("a != b = " + (a != b) );
        // System.out.println("a > b = " + (a > b) );
        // System.out.println("a < b = " + (a < b) );
        // System.out.println("b >= a = " + (b >= a) );
        // System.out.println("b <= a = " + (b <= a) );
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number ");
        int num1 = scanner.nextInt();
        System.out.println("Enter the second number");
        int num2 = scanner.nextInt();
        System.out.println("Enter ths relation expression e.g ==, !=, >, <, <=, >=");
        String operator = scanner.next();
        boolean result = false;
        switch (operator) {
            case "==":
                result = num1 == num2;
                break;
            case "!=":
                result = num1 != num2;
                break;
            case ">":
                result = num1 > num2;
                break;
            case "<":
                result = num1 < num2;
                break;
            case ">=":
                result = num1 >= num2;
                break;
            case "<=":
                result = num1 <= num2;
                break;
            default:
                System.out.println("Invalid operator");
        }
        System.out.println("The result is " + result);
    }
}