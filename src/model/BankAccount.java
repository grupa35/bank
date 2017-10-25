package model;

public class BankAccount extends Entity {

    private long nrB;
    private long accountBalance;
    private BankClient client;

    public long getNrB() {
        return nrB;
    }

    public long getAccountBalance() {
        return accountBalance;
    }

    public BankClient getClient() {
        return client;
    }

    public void setAccountBalance(long accountBalance) {
        this.accountBalance = accountBalance;
    }
}