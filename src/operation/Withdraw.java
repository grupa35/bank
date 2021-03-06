package operation;

public class Withdraw extends Operation {

	public Withdraw(String source, double amount){
		super(source, amount);
	}

	@Override
	public String getDescription() {
		StringBuilder builder = new StringBuilder();

		builder	.append("wypłata, ")
				.append("id: " + getId() + ", ")
				.append("z rachunku: " + getSourceAccountNumber() + ", ")
				.append("dnia: " + getDate() + ", ")
				.append("na kwote: " + getAmount() + " zł, ");

		return builder.toString();
	}
}
