package view;

import java.nio.charset.Charset;
import java.util.Scanner;

import currency.Currency;
import currency.CurrencyCollection;
import currency.CurrencyExchange;
import currency.Exchangeable;
import currency.XMLCurrencyCollection;
import encoder.StringEncoder;
import parser.XMLParser;
import resourceDataProvider.RemoteResourceDataProvider;
import resourceDataProvider.ResourceDataProvider;

public class View {

	ResourceDataProvider dataProvider;

	String uri;

	private Exchangeable currencyExchange;

	private CurrencyCollection currencyCollection;

	public View() {
		uri = "http://www.nbp.pl/kursy/xml/lastA.xml";
		initialize();
	}

	private void initialize() {
		initializeDataProvider(uri);
		initializeCurrencyCollection();
		initializeCurrencyExchange();
	}

	private void initializeDataProvider(String uri) {
		dataProvider = new RemoteResourceDataProvider(uri);
	}

	private void initializeCurrencyCollection() {
		StringEncoder stringEncoder = new StringEncoder();
		String xmlDataInString = stringEncoder.getStringFromByteArray(dataProvider.getData(),
				Charset.forName("ISO-8859-2"));
		XMLParser xmlParser = new XMLParser();
		currencyCollection = new XMLCurrencyCollection(xmlParser.buildXMLFile(xmlDataInString));
		
		currencyCollection.getAllCurrencies().add(new Currency("polski zloty", 1, "PLN", 1));
	}

	private void initializeCurrencyExchange() {
		currencyExchange = new CurrencyExchange();
		currencyExchange.setCurrencyCollection(currencyCollection);
	}

	public void printAllCurrencies() {
		currencyCollection.getAllCurrencies().forEach(this::printCurrency);
	}

	private void printCurrency(Currency currency) {
		System.out.println(buildCurrencyInformation(currency));
	}

	private String buildCurrencyInformation(Currency currency) {
		StringBuilder stringBuilder = new StringBuilder()
				.append(currency.getName() + "\t")
				.append(currency.getCode() + "\t")
				.append(currency.getPrice() + "\t")
				.append(currency.getMultiplier() + "\n");
		return stringBuilder.toString();
	}

	public void printExchangeCurrenciesView() {
		Scanner input = new Scanner(System.in);
		Double value;
		String currencyFromCode;
		String currencyToCode;
		System.out.print("podaj kod pierwszej waluty: ");
		currencyFromCode = input.next();
		System.out.print("podaj kod drugiej waluty: ");
		currencyToCode = input.next();
		System.out.print("podaj wartość: ");
		value = input.nextDouble();
		System.out.print("wynik: ");
		System.out.println(currencyExchange.exchange(currencyFromCode, currencyToCode, value));
		input.close();
	}

}
