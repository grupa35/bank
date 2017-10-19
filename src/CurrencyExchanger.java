import java.util.Scanner;

import view.View;

public class CurrencyExchanger {
	public static void main(String[] args) throws Exception {
		View view = new View();

		int wybor;
		while (true) {
			System.out.print("1 - pokaż kursy walut\n2 - wymień\n> ");
			Scanner input = new Scanner(System.in);
			wybor = input.nextInt();
			switch (wybor) {
			case 1: {
				view.printAllCurrencies();
			}
			case 2: {
				view.printExchangeCurrenciesView();
			}
			default: {
				System.exit(0);
			}
			}
			input.close();
		}
	}
}
