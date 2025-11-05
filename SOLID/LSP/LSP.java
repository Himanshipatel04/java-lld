package SOLID.LSP;

interface NonWithdrawableAccount {
    void deposit(int amount, String accNo);
}

interface WithdrawableAccount extends NonWithdrawableAccount {
    void withdraw(int amount, String accNo);
}

class SavingsAccount implements WithdrawableAccount {
    @Override
    public void deposit(int amount,String accNo){
        System.out.println("Depositing in savings account");
    }

    @Override
    public void withdraw(int amount,String accNo){
        System.out.println("Withdrawing from savings account");
    }
}

class CurrentAccount implements WithdrawableAccount {
    @Override
    public void deposit(int amount,String accNo){
        System.out.println("Depositing in current account");
    }

    @Override
    public void withdraw(int amount,String accNo){
        System.out.println("Withdrawing from current account");
    }
}

class FixedDepositAccount implements NonWithdrawableAccount {
    @Override
    public void deposit(int amount,String accNo){
        System.out.println("Depositing in fixed deposit account");
    }
}


public class LSP {

}
