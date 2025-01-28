import java.io.*;

// Book class implementing Serializable interface
class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String title;
    private String author;
    private double price;

    // Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Getters and toString() method for display
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book [Title: " + title + ", Author: " + author + ", Price: $" + price + "]";
    }
}

// Main class
public class S12BookSerialization {
    public static void main(String[] args) {
        String filePath = "book.ser";

        // Create a Book object
        Book book = new Book("Effective Java", "Ram", 99.99);

        // Serialize the Book object
        serializeBook(book, filePath);

        // Deserialize the Book object
        Book deserializedBook = deserializeBook(filePath);

        // Display the deserialized object
        if (deserializedBook != null) {
            System.out.println("Deserialized Book: " + deserializedBook);
        }
    }

    // Method to serialize a Book object to a file
    public static void serializeBook(Book book, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(book);
            System.out.println("Book object serialized to " + filePath);
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }
    }

    // Method to deserialize a Book object from a file
    public static Book deserializeBook(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Book) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
            return null;
        }
    }
}
