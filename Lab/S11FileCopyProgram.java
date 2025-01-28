import java.io.*;

public class S11FileCopyProgram {
    public static void main(String[] args) {
        // Define the source and destination file paths
        String sourceFilePath = "source.txt";
        String destinationFilePath = "destination.txt";

        // Use try-with-resources for automatic resource management
        try (
            BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))
        ) {
            String line;

            // Read each line from the source file and write it to the destination file
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Write a new line in the destination file
            }

            System.out.println("File content copied successfully from " + sourceFilePath + " to " + destinationFilePath);

        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file not found.");
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred.");
        }
    }
}
