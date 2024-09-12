public class ForEach {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println("Using for-each loop");
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("Using for loop");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        int length = arr.length;
        System.out.println("Length of array is: " + length);
    }
}
