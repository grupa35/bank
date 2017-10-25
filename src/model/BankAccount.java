package model;

public class BankAccount extends Entity {
    static int bankAccountCounter = 0;

    private String bankAccountNumber;
    private double balance;
    private BankClient client;

    public BankAccount() {
        super(bankAccountCounter++);
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public BankClient getClient() {
        return client;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private String generateAccountNumber() {
        return "11222233334444555566667777";
    }
}