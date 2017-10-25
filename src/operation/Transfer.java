package operation;

import model.BankAccount;

public class Transfer extends Operation {
	private String targetAccountNumber;

	private String title;
	
	public Transfer(String source, String target, String title, double amount){
	    super(source, amount);
		targetAccountNumber = target;
		this.title = title;
	}
	
	public String getTargetAccountNumber() {
		return targetAccountNumber;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String getDescription() {
		StringBuilder builder = new StringBuilder();

		builder	.append("przelew, ")
				.append("id: " + getId() + ", ")
				.append("tytuł: " + getTitle() + ", ")
				.append("z rachunku: " + getSourceAccountNumber() + ", ")
				.append("na rachunek: " + getTargetAccountNumber() + ", ")
				.append("dnia: " + getDate() + ", ")
				.append("na kwote: " + getAmount() + " zł, ");

		return builder.toString();
	}
}

