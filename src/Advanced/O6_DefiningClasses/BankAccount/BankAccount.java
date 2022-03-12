package Advanced.O6_DefiningClasses.BankAccount;

public class BankAccount {
    private static double interestRate = 0.02;
    private int accountsCounter = 0;
    private int ID;
    private double balance;

    public BankAccount() {
        this.accountsCounter ++;
        this.ID = accountsCounter;
        this.balance = 0;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }


}
