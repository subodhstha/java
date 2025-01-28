// Save this file as AccessModifiersDemo.java in the demo package
package demo;

public class AccessModifiersDemo {
    // Public attribute
    public String publicAttribute = "Public Attribute";

    // Private attribute
    private String privateAttribute = "Private Attribute";

    // Protected attribute
    protected String protectedAttribute = "Protected Attribute";

    // Package-private (default) attribute
    String packagePrivateAttribute = "Package-Private Attribute";

    // Public method
    public void publicMethod() {
        System.out.println("Public Method: Accessible from anywhere.");
    }

    // Private method
    private void privateMethod() {
        System.out.println("Private Method: Accessible only within this class.");
    }

    // Protected method
    protected void protectedMethod() {
        System.out.println("Protected Method: Accessible within the package or through inheritance.");
    }

    // Package-private (default) method
    void packagePrivateMethod() {
        System.out.println("Package-Private Method: Accessible only within the package.");
    }

    // Method to access all attributes and methods within the same class
    public void accessAll() {
        System.out.println("Inside the same class:");
        System.out.println(privateAttribute);
        privateMethod();
    }
}
