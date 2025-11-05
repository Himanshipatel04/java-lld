package SOLID.LSP.MethodRule;
// A Precondition must be statisfied before a method can be executed.
// Sub classes can weaken the precondition but cannot strengthen it.

//This is because suppose a class wants 8 character password as precondition and child class wants 10 character password as precondition, then client code which is using parent class reference to child class object will not be able to satisfy the precondition of child class as it is stronger than parent class precondition.
// Hence LSP is violated.

class User {
    // Precondition: Password must be at least 8 characters long
    public void setPassword(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long!");
        }
        System.out.println("Password set successfully");
    }
}

class AdminUser extends User {
    // Precondition: Password must be at least 6 characters
    @Override
    public void setPassword(String password) {
        if (password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long!");
        }
        System.out.println("Password set successfully");
    }
}

public class PreConditions {
    public static void main(String[] args) {
        User user = new AdminUser();
        user.setPassword("Admin1");  // Works fine: AdminUser allows shorter passwords
    }
}
