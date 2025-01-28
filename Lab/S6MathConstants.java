// Create a class MathConstants with a final variable for PI and a static method to calculate the area of a circle.
public class S6MathConstants {
    // Final constant for PI
    public static final double PI = 3.141;

    // Static method to calculate the area of a circle
    public static double calculateCircleArea(double radius) {
        return PI * radius * radius;
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Example usage of the MathConstants class
        double radius = 7.5; // Radius of the circle
        double area = S6MathConstants.calculateCircleArea(radius);

        // Display the result
        System.out.println("Radius of the circle: " + radius);
        System.out.println("Area of the circle: " + area);
    }
}
