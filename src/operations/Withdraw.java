package repository;

import java.util.Date;
import java.util.Random;

public class Withdraw extends Operation {

	Withdraw(Account source, double amount){
		sourceAccount = source.getBankNumber();
		this.amount = amount;
		date = new Date();
	}

	
}
