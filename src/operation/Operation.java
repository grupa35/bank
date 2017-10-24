package operation;

import model.Entity;

import java.util.Date;

public abstract class Operation extends Entity {
    protected double amount;
    protected Date date;
    protected String sourceAccountNumber;

    protected static long nextId = 0;

    Operation(BankAccount source, double amount) {
        super(nextId++);
        sourceAccountNumber = source.getBankAccountNumber();
        this.amount = amount;
        date = new Date();
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getSourceAccountNumber() {
        return sourceAccountNumber;
    }
}
