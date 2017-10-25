package model;

public class BankAccount extends Entity {
    static int bankAccountCounter = 0;

    private String bankAccountNumber;
    private BankClient client;
    private double balance;

    public BankAccount(BankClient client) {
        super(bankAccountCounter++);
        this.bankAccountNumber = generateAccountNumber();
        this.client = client;
        balance = 0.0;
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

    public void addAmount(double amount) {
        balance += amount;
    }

    private String generateAccountNumber() {
        return "11222233334444555566667777";
    }
}