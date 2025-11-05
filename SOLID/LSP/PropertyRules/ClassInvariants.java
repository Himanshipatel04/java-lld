package SOLID.LSP.PropertyRules;

// Invariant means a rule which will always hold true for a class
// This means that child class should not violate the invariants of the parent class. It can strengthen the invariant but cannot weaken it.

//Example: An account class is there with an invariant that balance should never be negative. A child class like SavingsAccount should also ensure that the balance is never negative. suppose there is a cheat class like FraudulentAccount which allows negative balance, it would violate the class invariant of the parent Account class.

// Class Invariant of a parent class Object should not be broken by child class Object.
// Hence child class can either maintain or strengthen the invariant but never narrows it down.

// Invariant: Balance cannot be negative
class BankAccount {
    protected double balance;

    public BankAccount(double b) {
        if (b < 0) throw new IllegalArgumentException("Balance can't be negative");
        balance = b;
    }

    public void withdraw(double amount) {
        if (balance - amount < 0) throw new RuntimeException("Insufficient funds");
        balance -= amount;
        System.out.println("Amount withdrawn. Remaining balance is " + balance);
    }
}

// Breaks invariant: Should not be allowed.
class CheatAccount extends BankAccount {
    public CheatAccount(double b) {
        super(b);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount; // LSP break! Negative balance allowed
        System.out.println("Amount withdrawn. Remaining balance is " + balance);
    }
}

public class ClassInvariants {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(100);
        bankAccount.withdraw(100);
    }
}

