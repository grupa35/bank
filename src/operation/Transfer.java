package operation;

public class Transfer extends Operation {
	private String targetAccountNumber;
	
	public Transfer(BankAccount source, BankAccount target, double amount){
	    super(source, amount);
		targetAccountNumber = target.getBankNumber();
	}
	
	public String getTargetAccountNumber() {
		return targetAccountNumber;
	}
}

