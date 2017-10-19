package currency;

import java.util.List;

public abstract class CurrencyCollection {
	protected List<Currency> currencyList;
	
	public List<Currency> getAllCurrencies() {
		return currencyList;
	}

	public Currency getItem(String code) {
		return currencyList.stream()
				.filter(currency -> currency.getCode().equals(code))
				.findFirst()
				.orElse(null);
	}
}
