package currency;

import java.util.Optional;

public class CurrencyExchange implements Exchangeable {

	private CurrencyCollection currencyCollection;

	public CurrencyExchange(CurrencyCollection currencyCollection) {
		this.currencyCollection = currencyCollection;
	}

	public CurrencyExchange() {
	};

	@Override
	public void setCurrencyCollection(CurrencyCollection currencyCollection) {
		this.currencyCollection = currencyCollection;
	}

	@Override
	public Double exchange(String currencyFromCode, String currencyToCode, double value) {
		Optional<Currency> currencyFrom = Optional.ofNullable(currencyCollection.getItem(currencyFromCode));
		Optional<Currency> currencyTo = Optional.ofNullable(currencyCollection.getItem(currencyToCode));

		if (currencyFrom.isPresent() && currencyTo.isPresent()) {
			return value * currencyFrom.map(this::calculateCurrencyValue).get()
					/ currencyTo.map(this::calculateCurrencyValue).get();
		}

		return null;
	}

	private double calculateCurrencyValue(Currency currency) {
		return currency.getMultiplier() * currency.getPrice();
	}

}
