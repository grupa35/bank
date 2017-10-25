import exception.InputLengthException;
import model.*;
import operation.Repository;
import session.Session;

import java.util.Arrays;
import java.util.Optional;

public class BankSupervisor {

    public static void main(String [] args) throws InputLengthException {
        PersonalData personalData01 = new PersonalData();
        personalData01.setName("Piotr");
 		personalData01.setSurname("Jakis");
 		personalData01.setPesel("97537156310");

		PersonalData personalData02 = new PersonalData();
 		personalData02.setName("Zbigniew");
 		personalData02.setSurname("Kot");
 		personalData02.setPesel("97537156310");

		PersonalData personalData03 = new PersonalData();
 		personalData03.setName("Zbigniew");
 		personalData03.setSurname("Him");
 		personalData03.setPesel("63927854921");

        CompanyData companyData01 = new CompanyData();
        companyData01.setName("Ta Firma");
        companyData01.setAddress("Jakaœ 20");
        companyData01.setNIP("7592039746");

        BankClient client0 = new PersonalBankClient();
 		BankClient client1 = new CompanyBankClient();
 		BankClient client2 = new PersonalBankClient();
 		BankClient client3 = new PersonalBankClient();
 		client0.setData(personalData01);
 		client0.setLogin("1234");
 		client0.setPassword("1234");
 		client1.setData(companyData01);
 		client1.setLogin("12345");
 		client1.setPassword("12345");
 		client2.setData(personalData02);
 		client2.setLogin("12");
 		client2.setPassword("12");
 		client3.setData(personalData03);
 		client3.setLogin("1");
 		client3.setPassword("1");

        Repository repository = new Repository();

        BankAccount acc0 = new BankAccount(client0);
 		BankAccount acc00 = new BankAccount(client0);
		BankAccount acc1 = new BankAccount(client1);
		BankAccount acc2 = new BankAccount(client2);
		BankAccount acc3 = new BankAccount(client3);
        repository.addClientList(Arrays.asList(client0, client1, client2, client3));
        repository.addAccountList(Arrays.asList(acc0, acc1, acc2, acc3));

        boolean isDataExistsTest = true;

 		Session session = new Session(repository);

 		if(isDataExistsTest) {
            try {
                session.login("12", "12");
            } catch (Exception e) {
                System.exit(0);
            }
        } else {
 		    try {
 		        session.login("01", "01");
            } catch (Exception e) {
                System.exit(0);
            }
        }

        Optional.ofNullable(session.getExecutor()).ifPresent(exe -> {

            BankAccount acc = session.getUserBankAccounts().get(0);
            System.out.println("Saldo mojego konta: " + acc.getBalance() + " zł");
            BankAccount accOther = session.getRepository().getAccount(0);   // numer wcześniej powinien być znany

            exe.makeWithdraw(acc.getBankAccountNumber(), 100);
            System.out.println("Saldo mojego konta: " + acc.getBalance() + " zł");

            exe.makeTransfer(acc.getBankAccountNumber(), accOther.getBankAccountNumber(), "pierwszy przelew", 255);
            System.out.println("Saldo mojego konta: " + acc.getBalance() + " zł");
            exe.printLog();
        });
    }
}
