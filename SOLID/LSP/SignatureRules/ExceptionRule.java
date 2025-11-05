package SOLID.LSP.SignatureRules;


// Exception Rule:
// A subclass should throw fewer or narrower exceptions 
// (but not additional or broader exceptions) than the parent.
// Java enforces this only for checked Exceptions.

/* 
└── java.lang.Exception                        // Conditions your application might want to catch
    ├── java.io.IOException                    // Checked I/O failures
    │   ├── java.io.FileNotFoundException
    │   ├── java.io.EOFException
    │   └── java.net.MalformedURLException
    ├── java.lang.ClassNotFoundException       // Checked reflect/… failures
    ├── java.lang.InterruptedException         // Checked thread interruption
    ├── java.sql.SQLException                  // Checked SQL/database errors
    ├── java.text.ParseException               // Checked parsing errors
    └── java.lang.RuntimeException             // Unchecked; subclasses may be thrown anywhere
        ├── java.lang.ArithmeticException      // e.g. divide by zero
        ├── java.lang.NullPointerException
        ├── java.lang.ArrayIndexOutOfBoundsException
        ├── java.lang.StringIndexOutOfBoundsException
        ├── java.lang.IllegalArgumentException
        │    └── java.lang.NumberFormatException
        ├── java.lang.IllegalStateException
        ├── java.lang.UnsupportedOperationException
        └── java.lang.IndexOutOfBoundsException // parent of the two “…OutOfBounds” above
*/

class Parent {
    public void getValue() throws RuntimeException {
        throw new RuntimeException("Parent error");
    }
}

class Child extends Parent {
    @Override
    public void getValue() throws ArithmeticException {
        throw new ArithmeticException("Child error");
        // throw new Exception("Child error"); // This is wrong & not allowed
    }
}

class Client {
    private Parent p;

    public Client(Parent p) {
        this.p = p;
    }

    public void takeValue() {
        try {
            p.getValue();
        } catch (RuntimeException e) {
            System.out.println("RuntimeException occurred: " + e.getMessage());
        }
    }
}

public class ExceptionRule {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child   = new Child();

        Client client1 = new Client(parent);
        Client client2 = new Client(child);
        
        client1.takeValue();  
        client2.takeValue();  
    }
}
