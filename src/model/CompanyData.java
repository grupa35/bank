package model;

import exception.InputLengthException;

public class CompanyData implements IData {
    private String name;
    private String address;
    private String NIP;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 0) {
            this.name = name;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) throws InputLengthException {

        int length = NIP.length();
        if (NIP.matches("[0-9]{10}")) {
            this.NIP = NIP;
        } else {
            throw new InputLengthException("The length of NIP is uncorrect");
        }

    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder()
                .append("name=" + getName() + "\t")
                .append("address=" + getAddress() + "\t")
                .append("NIP=" + getNIP() + "\t" + "\n");

        return stringBuilder.toString();

    }

    @Override
    public String dataContent() {
        return toString();
    }
}
