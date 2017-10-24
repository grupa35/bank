package session;

import operation.Repository;

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

    public List<BankAccount> getUserBankAccounts() {
        return repo.getClientAccounts(user);
    }

    public void login(int id, String pass) {
        BankClient user = repo.getClient(id);
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