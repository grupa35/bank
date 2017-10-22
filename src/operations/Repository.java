package repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Repository {
	private List<Withdraw> operationList;
	private List<BankClient> clientList;
	private List<Account> accountList;
	
	Repository(){
		operationList = new ArrayList<>(20);
		clientList = new ArrayList<>(20);
		accountList = new ArrayList<>(20);
	}
	
	public void add(Withdraw element){
		operationList.add(element);
	}
	
	public void add(BankClient element){
		clientList.add(element);
	}
	
	public void add(Account element){
		accountList.add(element);
	}
	
	
	////////Find by key
	public Withdraw findOperation(long key){
		Optional<Withdraw> entity; 
		entity = operationList.stream()
		        .filter(e -> e.getID() == key).findAny();
		if(entity.isPresent())
			return entity.get();
		return null;
	}
	
	public BankClient findClient(long key){
		Optional<BankClient> entity; 
		entity = clientList.stream()
		        .filter(e -> e.getID() == key).findAny();
		if(entity.isPresent())
			return entity.get();
		return null;
	}
	
	public Account findAccount(long key){
		Optional<Account> entity; 
		entity = accountList.stream()
		        .filter(e -> e.getID() == key).findAny();
		if(entity.isPresent())
			return entity.get();
		return null;
	}
	
	//////////find By Phrase
	public List<Withdraw> findOperation(String phrase){
		List<Withdraw> oList = new ArrayList<>(1);
		operationList.stream()
		        .filter( e -> findAccount(e.getNrAccSource()).getClient().getData().dataContent().contains(phrase)).forEach((g) -> oList.add(g));
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
		
		Withdraw oper0 = new Withdraw(acc0, 100);
		Withdraw oper1 = new Transfer(acc1, acc0, 200);
		Withdraw oper2 = new Withdraw(acc2, 300);
		Withdraw oper3 = new Withdraw(acc3, 400);
		
		Repository r = new Repository();
		
		r.add(client0);
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
		r.add(oper3);
		
		System.out.println(client0.getData().dataContent());
		System.out.println(r.findClient(client1.getID()).getData());
		System.out.println(r.findOperation(oper1.getID()).getNrAccSource());
		System.out.println(r.findOperation(oper1.getID()).getNrAccTarget());
		System.out.println(r.findAccount(acc0.getID()).getClient().getData().toString());
		System.out.println(acc0.getClient().getData());//.getData().toString());
		System.out.println();
		
		r.findAccount("Piotr").forEach( (a) -> System.out.println("A :" + a.getID()));
		r.findClient("Zbigniew").forEach( (c) -> System.out.println("C :" + c.getData()));
		r.findOperation("Zbigniew").forEach( (o) -> System.out.println("O :" + o.getID()));
	}

}
