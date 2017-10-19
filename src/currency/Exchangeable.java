package currency;

public interface Exchangeable {
	public Double exchange(String currencyFromCode, String currencyToCode, double value);

	public void setCurrencyCollection(CurrencyCollection currencyCollection);
}
