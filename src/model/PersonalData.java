package model;

import exception.InputLengthException;

public class PersonalData implements IData {
    private String name;
    private String surname;
    private String pesel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.matches("[A-Z][a-z]+")) {
            this.name = name;
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname.matches("[A-Z][a-z]+")) {
            this.surname = surname;
        }
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) throws InputLengthException{
        int length = String.valueOf(pesel).length();
        if (length == 11) {
            this.pesel = pesel;
        } else {
            throw new InputLengthException("The length of pesel is uncorrect");
        }

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder()
                .append("name=" + getName() + "\t")
                .append("surname=" + getSurname() + "\t")
                .append("PESEL=" + getPesel() + "\t" + "\n");

        return stringBuilder.toString();
    }
}