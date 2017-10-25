package executor;

import model.BankAccount;
import operation.Operation;
import operation.Repository;
import operation.Transfer;
import operation.Withdraw;

import javax.rmi.CORBA.Util;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.List;

public class Executor {
    private Repository repository;

    List<String> log = new ArrayList<>();
    private List<BankAccount> userBankAccounts;

    public Executor(Repository repository) {

        this.repository = repository;
    }

    public boolean makeTransfer(String sourceBankAccountNumber, String targetBankAccountNumber, String title, double amount) {
        BankAccount bankAccount = repository.getAccount(sourceBankAccountNumber);
        if(bankAccount != null) {
            Transfer transfer = new Transfer(sourceBankAccountNumber, targetBankAccountNumber, title, amount);
            bankAccount.addAmount(-Math.abs(transfer.getAmount()));
            repository.add(transfer);
            log.add(transfer.getDescription());
            return true;
        }

        return false;
    }

    public boolean makeWithdraw(String sourceBankAccountNumber, double amount) {
        BankAccount bankAccount = repository.getAccount(sourceBankAccountNumber);
        if(bankAccount != null) {
            Withdraw withdraw = new Withdraw(sourceBankAccountNumber, amount);
            bankAccount.addAmount(-Math.abs(withdraw.getAmount()));
            repository.add(withdraw);
            log.add(withdraw.getDescription());
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
