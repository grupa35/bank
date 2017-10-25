package operation;

import model.BankAccount;
import model.Entity;

import java.util.Date;

public abstract class Operation extends Entity {
    protected double amount;
    protected Date date;
    protected String sourceAccountNumber;

    protected static long nextId = 0;

    Operation(String source, double amount) {
        super(nextId++);
        sourceAccountNumber = source;
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

    public abstract String getDescription();
}
