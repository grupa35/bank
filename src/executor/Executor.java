package executor;

import model.BankAccount;
import operation.Operation;
import operation.Repository;
import operation.Transfer;
import operation.Withdraw;

import java.util.ArrayList;
import java.util.List;

public class Executor {
    private Repository repository;

    List<String> log = new ArrayList<>();

    public Executor(Repository repository) {

        this.repository = repository;
    }

    public boolean makeTransfer(String sourceBankAccountNumber, String targetBankAccountNumber, String title, double amount) {
        BankAccount bankAccount = repository.getAccount(sourceBankAccountNumber);
        if(bankAccount != null) {
            Transfer transfer = new Transfer(sourceBankAccountNumber, targetBankAccountNumber, title, amount);
            repository.add(transfer);
            log.add(transfer.getDescription());
            return true;
        }

        return false;
    }

    public boolean makeWithdraw(String sourceBankAccountNumber, double amount) {
        BankAccount bankAccount = repository.getAccount(sourceBankAccountNumber);
        if(bankAccount != null) {
            Withdraw transfer = new Withdraw(sourceBankAccountNumber, amount);
            repository.add(transfer);
            log.add(transfer.getDescription());
            return true;
        }

        return false;
    }

    private void addRecordToLog(Operation operation) {
        log.add(operation.getDescription());
    }

    public void printLog() {
        log.forEach(System.out::println);
    }
}
