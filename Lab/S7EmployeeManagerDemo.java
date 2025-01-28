// 7. Design a base class Employee with attributes name and salary, and a derived class
// Manager with additional attributes department. Override a method
// displayDetails() in both classes.
// Base class Employee
class Employee {
    protected String name;
    protected double salary;

    // Constructor for Employee
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Method to display details
    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

// Derived class Manager
class Manager extends Employee {
    private String department;

    // Constructor for Manager
    public Manager(String name, double salary, String department) {
        super(name, salary); // Call the base class constructor
        this.department = department;
    }

    // Overriding displayDetails() method
    @Override
    public void displayDetails() {
        System.out.println("Manager Details:");
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Department: " + department);
    }
}

// Main class to test the implementation
public class S7EmployeeManagerDemo {
    public static void main(String[] args) {
        // Creating an Employee object
        Employee emp = new Employee("Ram", 72200);
        emp.displayDetails();

        System.out.println();

        // Creating a Manager object
        Manager mgr = new Manager("Hari", 65000, "IT");
        mgr.displayDetails();
    }
}
