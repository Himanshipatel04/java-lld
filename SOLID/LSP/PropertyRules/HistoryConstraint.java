package SOLID.LSP.PropertyRules;

// History Constraint Rule:
// A subtype should not strengthen the history constraint of the supertype.
// This means that if a supertype allows certain state changes over time, the subtype should also
// allow those same state changes and not impose additional restrictions.


//Suppose an account class, withdrawls is always allowed as long as sufficient balance is there. If a child class FixedDepositAccount is created which allows withdrawls only on specific dates, it would violate the history constraint of the parent Account class.
// Here, the parent class Account allows withdrawls at any time (given sufficient balance), but the child class SavingsAccount restricts this by adding a new rule (only on weekdays). This change in allowed state changes over time violates the history constraint.


// Subclass methods should not be allowed state changes that
// the base class never allowed.

class BankAccount {
    protected double balance;

    public BankAccount(double b) {
        if (b < 0) throw new IllegalArgumentException("Balance can't be negative");
        this.balance = b;
    }

    // History Constraint: withdraw should be allowed
    public void withdraw(double amount) {
        if (balance - amount < 0) throw new RuntimeException("Insufficient funds");
        balance -= amount;
        System.out.println("Amount withdrawn. Remaining balance is " + balance);
    }
}

class FixedDepositAccount extends BankAccount {
    public FixedDepositAccount(double b) {
        super(b);
    }

    // LSP break! History constraint broken!
    // Parent class behavior changed: Now withdraw is not allowed.
    // This class will break client code that relies on withdraw.
    @Override
    public void withdraw(double amount) {
        throw new RuntimeException("Withdraw not allowed in Fixed Deposit");
    }
}

public class HistoryConstraint {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(100);
        bankAccount.withdraw(100);
    }
}