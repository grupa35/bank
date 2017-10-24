import java.util.Arrays;
import java.util.Optional;

public class BankSupervisor {

    public static void main(String [] args) {
        BankClientData personalData01 = new PersonalData();
        personalData01.setName("Piotr");
 		personalData01.setSurname("Jakis");
 		personalData01.setPesel("97537156310l");

        BankClientData personalData02 = new PersonalData();
 		personalData02.setName("Zbigniew");
 		personalData02.setSurname("Kot");
 		personalData02.setPesel("97537156310l");

 		BankClientData personalData03 = new PersonalData();
 		personalData03.setName("Zbigniew");
 		personalData03.setSurname("Him");
 		personalData03.setPesel("6392785492l");

        BankClientData companyData01 = new CompanyData();
        companyData01.setName("Ta Firma");
        companyData01.setAddress("Jakaœ 20");
        companyData01.setNIP("37592039746");

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

        Account acc0 = new Account(client0);
 		acc0.setBalance(1000);

 		Account acc00 = new Account(client0);
 		acc00.setBalance(11000);

 		Account acc1 = new Account(client1);
 		acc1.setBalance(20000);

 		Account acc2 = new Account(client2);
 		acc1.setBalance(3000);

 		Account acc3 = new Account(client3);
 		acc1.setBalance(4000);

        repository.addBankClients(Arrays.asList(client0, client1, client2, client3));
        repository.addBankAccounts(Arrays.asList(acc0, acc1, acc2, acc3));

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
            System.out.println(exe.getBalanse());

            BankAccount acc = exe.getUserBankAccounts().get(0);
            BankAccount accOther = exe.getBankAccountById(0);   // numer wcześniej powinien być znany

            exe.makeWithdraw(accNum.getBankNumber(), 100);
            System.out.println(exe.getBalance());

            exe.makeTransfer(accNum.getBankNumber(), accOther.getBankNumber(), 255);
            System.out.print(exe.getBalance());
        });
    }
}
