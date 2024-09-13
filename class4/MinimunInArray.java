// Lab-6
// Write a java program showing passing array to a method to find the minimun among the given input data.
import java.util.Arrays;
public class MinimunInArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println("Minimum value in the array is: " + findMin(arr));
    }
    
    public static int findMin(int[] arr) {
        Arrays.sort(arr);
        return arr[0];
    }
}
