// using RandomAccess file to access file content randomly
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomFileAccess {
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("D:\\Java\\randomAccessFile.txt", "rw");

            file.seek(0); 
            file.writeUTF("Hello, World!");

            file.seek(20); 
            file.writeUTF("Random Access File");

            file.seek(0); 
            System.out.println("Data at position 0: " + file.readUTF());

            file.seek(20); 
            System.out.println("Data at position 20: " + file.readUTF());

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}