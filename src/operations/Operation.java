package repository;

import java.util.Date;

public abstract class Operation extends Entity implements iOperation {
	protected double amount;
	protected Date date;
	protected String sourceAccount;
	
	protected static long nextId = 0;
	
	Operation(){
		super(nextId++);	
	}
	
	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public Date getDate() {
		return date;
	}
	
	@Override
	public String getSourceAccountNumber() {
		return sourceAccount;
	}
}
