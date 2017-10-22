package repository;


public class Transfer extends Withdraw {
	long nrAccTarget;
	
	Transfer(Account source, Account target, double amount){
		super(source, amount);
		this.nrAccTarget = target.getNrAccount();	
	}
	
	@Override
	public long getNrAccTarget() {
		return nrAccTarget;
	}

	
}

