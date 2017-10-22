package session;

import encoder.StringEncoder;

import java.security.MessageDigest;

public class Session {
    private Repository repo;
    private Executor exec;
    private BankClient user;

    public Session() {
        this.repo = new Repository();
    }

    public Executor getExecutor() {
        return exec;
    }

    public Repository getRepository() {
        return repo;
    }

    public List<UserBankAccount> getUserBankAccounts() {
        return repo.getUserBankAccountsById(user.getId());
    }

    public void login(int id, String pass) {
        BankClient user = repo.getBankClientById(id);
        if(this.checkValidity(user, pass))
            initializeAfterLogin(user);
        else
            throw new IllegalArgumentException("Invalid password.");
    }

    private boolean checkValidity(BankClient user, String pass) {
        if (user == null) {
            throw new IllegalArgumentException("Invalid login.");
        } else {
            pass = user.hashFunc(pass);
            return user.getPassword.equals(pass);
        }
    }

    private void initializeAfterLogin(BankClient user) {
        this.user = user;
        this.exec = new Executor(this.repo);
    }

    public BankClient getUser() {
        return user;
    }
}