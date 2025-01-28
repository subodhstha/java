// Save this file as AccessModifiersTest.java in the test package
package test;

import demo.AccessModifiersDemo;

public class AccessModifiersTest extends AccessModifiersDemo {
    public static void main(String[] args) {
        AccessModifiersDemo obj = new AccessModifiersDemo();

        // Accessing public members
        System.out.println("Public Attribute: " + obj.publicAttribute);
        obj.publicMethod();

        // Attempting to access private members (will cause errors)
        // System.out.println(obj.privateAttribute); // Not accessible
        // obj.privateMethod(); // Not accessible

        // Attempting to access package-private members (will cause errors)
        // System.out.println(obj.packagePrivateAttribute); // Not accessible
        // obj.packagePrivateMethod(); // Not accessible

        // Accessing protected members through inheritance
        AccessModifiersTest derivedObj = new AccessModifiersTest();
        System.out.println("Protected Attribute (via inheritance): " + derivedObj.protectedAttribute);
        derivedObj.protectedMethod();

        // Accessing all members within the same class (inside AccessModifiersDemo)
        obj.accessAll();
    }
}
