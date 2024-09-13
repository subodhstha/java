 class BaseClass {
    public void riskyMethod() throws Exception {
        throw new Exception("Exception thrown in BaseClass");
    }
}

class DerivedClass extends BaseClass {
    @Override
    public void riskyMethod() {
        try {
            super.riskyMethod();
        } catch (Exception e) {
            System.out.println("Exception caught in DerivedClass: " + e.getMessage());
        }
    }
}

public class ExceptionHandlingAndInheritance {
    public static void main(String[] args) {
        DerivedClass derived = new DerivedClass();
        derived.riskyMethod();
    }
}