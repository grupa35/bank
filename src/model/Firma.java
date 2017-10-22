package com.example.bank;

public class Firma extends BankClient{

    public Firma(DaneFirmy dane, String haslo){
        this.id++;
        this.dane = dane;
        this.haslo = haslo;
    }

}
