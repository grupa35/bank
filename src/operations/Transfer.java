package repository;

import java.util.Date;

public class Transfer extends Operation {
	String targetAccount;
	
	Transfer(Account source, Account target, double amount){
		sourceAccount = source.getBankNumber();
		this.amount = amount;
		date = new Date();
		targetAccount = target.getBankNumber();	
	}
	
	public String getTargetAccountNumber() {
		return targetAccount;
	}
	
}

