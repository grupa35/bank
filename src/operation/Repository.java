package operation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Repository {
	private List<Operation> operationList;
	private List<BankClient> clientList;
	private List<BankAccount> accountList;
	
	public Repository(){
		operationList = new ArrayList<>();
		clientList = new ArrayList<>();
		accountList = new ArrayList<>();
	}

	public void add(Withdraw element){
		operationList.add(element);
	}
	
	public void add(BankClient element){
		clientList.add(element);
	}
	
	public void add(BankAccount element){
		accountList.add(element);
	}

	public void addOperationList(List<Operation> list){
		operationList.addAll(list);
	}
	
	public void addClientList(List<BankClient> list){
		clientList.addAll(list);
	}
	
	public void addAccountList(List<BankAccount> list){
		accountList.addAll(list);
	}

	public Operation getOperation(long key){ 
		return operationList.stream()
				.filter(e -> e.getId() == key)
				.findAny()
				.orElse(null);
	}
	
	public BankClient getClient(long key){ 
		return clientList.stream()
				.filter(e -> e.getId() == key)
				.findAny()
				.orElse(null);
	}
	
	public BankAccount getAccount(long key){
		return accountList.stream()
				.filter(e -> e.getId() == key)
				.findAny()
				.orElse(null);
	}
	
	public BankAccount getAccount(String bankNumber){
		return accountList.stream()
				.filter(e -> e.getBankNumber().equals(bankNumber))
				.findAny()
				.orElse(null);
	}

	public List<Operation> getAllOperations(){
		return operationList;
	}
	
	public List<BankClient> getAllClients(){
		return clientList;
	}
	
	public List<BankAccount> getAllAccounts(){
		return accountList;
	}
	
	
	public List<BankAccount> getClientAccounts(BankClient client){
		return accountList.stream()
				.filter(e -> e.getClient().equals(client))
				.collect(Collectors.toList());
	}
	
	public List<Operation> findOperations(String phrase){
		return operationList.stream()
				.filter( e -> getAccount(e.getSourceAccountNumber())
				.getClient().getData().dataContent().contains(phrase))
				.collect(Collectors.toList());
	}
	
	public List<BankAccount> findAccounts(String phrase){
		return accountList.stream()
				.filter(e -> e.getClient().getData().dataContent().contains(phrase))
				.collect(Collectors.toList());
	}
	
	public List<BankClient> findClients(String phrase){
		return clientList.stream()
				.filter(e -> e.getData().dataContent().contains(phrase))
				.collect(Collectors.toList());
	}
	
	
	
	
//	public static void main(String[] args)
//	{
//		PersonalData data0 = new PersonalData();
//		data0.setName("Piotr");
//		data0.setSurname("Jaki�");
//		data0.setPesel(97537156310l);
//
//		CompanyData data1 = new CompanyData();
//		data1.setName("Ta Firma");
//		data1.setAddress("Jaka� 20");
//		data1.setNIP(37592039746l);
//
//		PersonalData data2 = new PersonalData();
//		data2.setName("Zbigniew");
//		data2.setSurname("Kot");
//		data2.setPesel(97537156310l);
//
//		PersonalData data3 = new PersonalData();
//		data3.setName("Zbigniew");
//		data3.setSurname("Him");
//		data3.setPesel(6392785492l);
//
//		BankClient client0 = new Klient();
//		BankClient client1 = new Firma();
//		BankClient client2 = new Klient();
//		BankClient client3 = new Klient();
//
//		client0.setData(data0);
//		client1.setData(data1);
//		client2.setData(data2);
//		client3.setData(data3);
//
//		BankAccount acc0 = new BankAccount(client0);
//		acc0.setBalance(1000);
//		BankAccount acc00 = new BankAccount(client0);
//		acc00.setBalance(11000);
//
//		BankAccount acc1 = new BankAccount(client1);
//		acc1.setBalance(20000);
//
//		BankAccount acc2 = new BankAccount(client2);
//		acc1.setBalance(3000);
//
//		BankAccount acc3 = new BankAccount(client3);
//		acc1.setBalance(4000);
//
//		Operation oper0 = new Withdraw(acc0, 100);
//		Operation oper1 = new Transfer(acc1, acc0, 200);
//		Operation oper2 = new Withdraw(acc2, 300);
//		Operation oper3 = new Withdraw(acc3, 400);
//
//		Repository r = new Repository();
//
//		List<BankClient> cL = new ArrayList<> (5);
//		List<Operation> wL = new ArrayList<> (5);
//		List<BankAccount> aL = new ArrayList<> (5);
//
//		cL.add(client0);
//		cL.add(client1);
//		cL.add(client2);
//		cL.add(client3);
//
//		aL.add(acc0);
//		aL.add(acc00);
//		aL.add(acc1);
//		aL.add(acc2);
//		aL.add(acc3);
//
//		wL.add(oper0);
//		wL.add(oper1);
//		wL.add(oper2);
//		wL.add(oper3);
//
//		r.addClientList(cL);
//		r.addAccountList(aL);
//		r.addOperationList(wL);
//
//
//		/*r.add(client0);
//		r.add(client1);
//		r.add(client2);
//		r.add(client3);
//
//		r.add(acc0);
//		r.add(acc00);
//		r.add(acc1);
//		r.add(acc2);
//		r.add(acc3);
//
//		r.add(oper0);
//		r.add(oper1);
//		r.add(oper2);
//		r.add(oper3);*/
//		r.getClientAccounts(client0).forEach(a -> System.out.println("Accounts:" + a.getId() ));
//		System.out.println();
//		r.getAllClients().forEach(a -> System.out.println("Clients:" + a.getData() ));
//		System.out.println(client0.getData().dataContent());
//		System.out.println(r.getClient(client1.getId()).getData());
//		System.out.println(r.getOperation(oper1.getId()).getSourceAccountNumber());
//		System.out.println(r.getOperation(oper2.getId()).getSourceAccountNumber());
//		System.out.println(r.getAccount(acc0.getId()).getClient().getData().toString());
//		System.out.println(acc0.getClient().getData());//.getData().toString());
//		System.out.println();
//
//		System.out.println(r.getOperation(oper1.getId()).getSourceAccountNumber());
//		System.out.println(r.getOperation(oper1.getId()).getSourceAccountNumber());
//
//		r.findAccounts("Piotr").forEach( (a) -> System.out.println("A :" + a.getId()));
//		r.findClients("Zbigniew").forEach( (c) -> System.out.println("C :" + c.getData()));
//		r.findOperations("Zbigniew").forEach( (o) -> System.out.println("O :" + o.getId()));
//	}

}
