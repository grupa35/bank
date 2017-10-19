package currency;

import java.util.ArrayList;
import java.util.StringTokenizer;

import org.w3c.dom.Document;

public class XMLCurrencyCollection extends CurrencyCollection {
	
	public XMLCurrencyCollection(Document data) {
		createList(data);
	}
	
	public void createList(Document data)
	{
		currencyList = new ArrayList<>(35);
		
		int length = data.getChildNodes().item(0).getChildNodes().getLength();
		for(int j = 5; j < length; j = j + 2)
		{
			String record = data.getChildNodes().item(0).getChildNodes().item(j).getTextContent();
			StringTokenizer tokenizer = new StringTokenizer(record, "\n");
		
			currencyList.add(new Currency());
			for(int k = 0; tokenizer.hasMoreTokens() && k < 4; k++)
			{
				
				String line = tokenizer.nextToken();
				
				int i = (j - 5) / 2;
				switch(k)
				{
				case 0:
					line = line.substring(6);
					currencyList.get(i).setName(line);
					break;
				case 1:
					line = line.replaceAll(",", ".");
					currencyList.get(i).setMultiplier(Double.parseDouble(line));
					break;
				case 2:
					line = line.substring(6);
					currencyList.get(i).setCode(line);
					break;
				case 3:
					line = line.replaceAll(",", ".");
					currencyList.get(i).setPrice(Double.parseDouble(line));
					break;
				}	
			}
		}
	}

}
