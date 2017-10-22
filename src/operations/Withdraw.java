package repository;

import java.util.Date;
import java.util.Random;

public class Withdraw implements iOperation, iEntity {
	double amount;
	Date date;
	long nrAccSource;
	long id;
	
	static long nextId = 0;
	
	Withdraw()
	{}
	
	Withdraw(Account source, double amount){
		nrAccSource = source.getNrAccount();
		this.amount = amount;
		id = nextId;
		nextId++;
		date = new Date();
		
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
	public long getID() {
		return id;
	}
	
	@Override
	public long getNrAccSource() {
		return nrAccSource;
	}
	
	@Override
	public long getNrAccTarget() {
		return -1;
	}
}
