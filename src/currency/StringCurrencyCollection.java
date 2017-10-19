package currency;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class StringCurrencyCollection extends CurrencyCollection {
	
	StringCurrencyCollection(String data) {
		createList(data);
	}

	public void createList(String data) {
		StringTokenizer tokenizer = new StringTokenizer(data, "\n\n");

		currencyList = new ArrayList<>(20);
		String str;
		int i = -1;

		String startWrap = "<nazwa_waluty>";
		String endWrap = "</nazwa_waluty>";

		while (tokenizer.hasMoreTokens()) {
			String line = tokenizer.nextToken();

			if (line.contains("<pozycja>")) {
				currencyList.add(new Currency());
				i++;
			} else {
				str = extract(startWrap, line, endWrap, tokenizer);
				if (str != null) {
					switch (startWrap) {
					case "<nazwa_waluty>":
						str = str.substring(6, str.length());
						str = str.replace("\r", "");
						currencyList.get(i).setName(str);
						startWrap = "<przelicznik>";
						endWrap = "</przelicznik>";
						break;
					case "<przelicznik>":
						str = str.replaceAll(",", ".");
						currencyList.get(i).setMultiplier(Double.parseDouble(str));
						startWrap = "<kod_waluty>";
						endWrap = "</kod_waluty>";
						break;
					case "<kod_waluty>":
						str = str.substring(6, str.length());
						str = str.replace("\r", "");
						currencyList.get(i).setCode(str);
						startWrap = "<kurs_sredni>";
						endWrap = "</kurs_sredni>";
						break;
					case "<kurs_sredni>":
						str = str.replace(',', '.');
						currencyList.get(i).setPrice(Double.parseDouble(str));
						startWrap = "<nazwa_waluty>";
						endWrap = "</nazwa_waluty>";
						break;
					}
				}
			}
		}
	}

	private String extract(String startWrap, String line, String endWrap, StringTokenizer tokenizer) {
		if (line.contains(startWrap)) { 
			line = line.replace(startWrap, "");

			if (line.contains(endWrap)) {
				line = line.replace(endWrap, "");
				return line;
			} else {
				while (!line.contains(endWrap)) {
					line = line + tokenizer.nextToken();
				}
				line = line.replace(endWrap, "");
				return line;
			}
		}
		return null;
	}

}
