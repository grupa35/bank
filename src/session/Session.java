package session

public class Session {
    private Repository repo;
    private Executor exec;

    public Executor getExecutor() {
        return exec;
    }

    public Repository getRepository() {
        return repo;
    }

    public UserBankAccount getUserBankAccounts {
        return repo.getUserBankAccountsById(id);
    }

    public boolean login(int id, String pass) {
        return this.checkValidity(id, pass))
    }

    private boolean checkValidity(int id, String pass) {
        BankUser bankUser = repo.getBankClientById(id);
        if (bankuser == null) {
            throw new IllegalArgumentException("Invalid login.");
        } else {
            return bankUser.getPassword.equals(pass);
        }
    }

}