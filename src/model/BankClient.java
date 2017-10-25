package model;

import java.security.MessageDigest;

public class BankClient extends Entity {
    static long bankClientCounter = 0;

    private String login;

    private String password;

    private IData data;

    public BankClient() {
        super(bankClientCounter++);
    }

    public BankClient(IData data) {
        super(bankClientCounter++);
        this.data = data;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {

        this.password = hashPassword(password);
    }

    public IData getData() {
        return data;
    }

    public void setData(IData data) {
        this.data = data;
    }

    private String hashPassword(String password) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public boolean equalsPassword(String password) {
        return this.password.equals(hashPassword(password));
    }
}
