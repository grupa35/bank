package repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Repository {
	private List<Operation> operationList;
	private List<BankClient> clientList;
	private List<Account> accountList;
	
	Repository(){
		operationList = new ArrayList<>(20);
		clientList = new ArrayList<>(20);
		accountList = new ArrayList<>(20);
	}
	
	////////add
	public void add(Withdraw element){
		operationList.add(element);
	}
	
	public void add(BankClient element){
		clientList.add(element);
	}
	
	public void add(Account element){
		accountList.add(element);
	}
	
	
	////////add
	public void addOperationList(List<Operation> list){
		operationList.addAll(list);
	}
	
	public void addClientList(List<BankClient> list){
		clientList.addAll(list);
	}
	
	public void addAccontList(List<Account> list){
		accountList.addAll(list);
	}
	
	
	////////get
	public Operation getOperation(long key){
		Optional<Operation> entity; 
		entity = operationList.stream()
		        .filter(e -> e.getId() == key).findAny();
		if(entity.isPresent())
			return entity.get();
		return null;
	}
	
	public BankClient getClient(long key){
		Optional<BankClient> entity; 
		entity = clientList.stream()
		        .filter(e -> e.getId() == key).findAny();
		if(entity.isPresent())
			return entity.get();
		return null;
	}
	
	public Account getAccount(long key){
		Optional<Account> entity; 
		entity = accountList.stream()
		        .filter(e -> e.getId() == key).findAny();
		if(entity.isPresent())
			return entity.get();
		return null;
	}
	
	public Account getAccount(String bankNumber){
		Optional<Account> entity; 
		entity = accountList.stream()
		        .filter(e -> e.getBankNumber().equals(bankNumber)).findAny();
		if(entity.isPresent())
			return entity.get();
		return null;
	}
	
	//////////get List
	public List<Operation> getAllOperations(){
		return operationList;
	}
	
	public List<BankClient> getAllClients(){
		return clientList;
	}
	
	public List<Account> getAllAccounts(){
		return accountList;
	}
	
	
	public List<Account> getClientAccounts(BankClient client){
		List<Account> aList = new ArrayList<>(1);
		accountList.stream()
		        .filter(e -> e.getClient().equals(client)).forEach((g) -> aList.add(g));
		return aList;
	}
	
	
	//////////find By Phrase
	public List<Operation> findOperation(String phrase){
		List<Operation> oList = new ArrayList<>(1);
		operationList.stream()
		        .filter( e -> getAccount(e.getSourceAccountNumber()).getClient().getData().dataContent().contains(phrase)).forEach(f -> oList.add(f));
		return oList;
	}
	
	public List<Account> findAccount(String phrase){
		List<Account> aList = new ArrayList<>(1);
		accountList.stream()
		        .filter(e -> e.getClient().getData().dataContent().contains(phrase)).forEach((g) -> aList.add(g));
		return aList;
	}
	
	public List<BankClient> findClient(String phrase){
		List<BankClient> cList = new ArrayList<>(1);
		clientList.stream()
		        .filter(e -> e.getData().dataContent().contains(phrase)).forEach((g) -> cList.add(g));
		return cList;
	}
	
	
	
	
	public static void main(String[] args) 
	{
		PersonalData data0 = new PersonalData();
		data0.setName("Piotr");
		data0.setSurname("Jakiœ");
		data0.setPesel(97537156310l);
		
		CompanyData data1 = new CompanyData();
		data1.setName("Ta Firma");
		data1.setAddress("Jakaœ 20");
		data1.setNIP(37592039746l);
		
		PersonalData data2 = new PersonalData();
		data2.setName("Zbigniew");
		data2.setSurname("Kot");
		data2.setPesel(97537156310l);
		
		PersonalData data3 = new PersonalData();
		data3.setName("Zbigniew");
		data3.setSurname("Him");
		data3.setPesel(6392785492l);
		
		BankClient client0 = new Klient();
		BankClient client1 = new Firma();
		BankClient client2 = new Klient();
		BankClient client3 = new Klient();
		
		client0.setData(data0);
		client1.setData(data1);
		client2.setData(data2);
		client3.setData(data3);
		
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
		
		Operation oper0 = new Withdraw(acc0, 100);
		Operation oper1 = new Transfer(acc1, acc0, 200);
		Operation oper2 = new Withdraw(acc2, 300);
		Operation oper3 = new Withdraw(acc3, 400);
		
		Repository r = new Repository();
		
		List<BankClient> cL = new ArrayList<> (5);
		List<Operation> wL = new ArrayList<> (5);
		List<Account> aL = new ArrayList<> (5);
		
		cL.add(client0);
		cL.add(client1);
		cL.add(client2);
		cL.add(client3);
		
		aL.add(acc0);
		aL.add(acc00);
		aL.add(acc1);
		aL.add(acc2);
		aL.add(acc3);
		
		wL.add(oper0);
		wL.add(oper1);
		wL.add(oper2);
		wL.add(oper3);
		
		r.addClientList(cL);
		r.addAccontList(aL);
		r.addOperationList(wL);
		
		
		/*r.add(client0);
		r.add(client1);
		r.add(client2);
		r.add(client3);
		
		r.add(acc0);
		r.add(acc00);
		r.add(acc1);
		r.add(acc2);
		r.add(acc3);
		
		r.add(oper0);
		r.add(oper1);
		r.add(oper2);
		r.add(oper3);*/
		r.getClientAccounts(client0).forEach(a -> System.out.println("Accounts:" + a.getId() ));
		System.out.println();
		r.getAllClients().forEach(a -> System.out.println("Clients:" + a.getData() ));
		System.out.println(client0.getData().dataContent());
		System.out.println(r.getClient(client1.getId()).getData());
		System.out.println(r.getOperation(oper1.getId()).getSourceAccountNumber());
		System.out.println(r.getOperation(oper2.getId()).getSourceAccountNumber());
		System.out.println(r.getAccount(acc0.getId()).getClient().getData().toString());
		System.out.println(acc0.getClient().getData());//.getData().toString());
		System.out.println();
	
		System.out.println(r.getOperation(oper1.getId()).getSourceAccountNumber());
		System.out.println(r.getOperation(oper1.getId()).getSourceAccountNumber());
		
		r.findAccount("Piotr").forEach( (a) -> System.out.println("A :" + a.getId()));
		r.findClient("Zbigniew").forEach( (c) -> System.out.println("C :" + c.getData()));
		r.findOperation("Zbigniew").forEach( (o) -> System.out.println("O :" + o.getId()));
	}

}
