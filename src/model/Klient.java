package com.example.bank;

public class Klient extends BankClient {

    public Klient(DaneOsobowe dane, String haslo){
        this.id++;
        this.dane = dane;
        this.haslo = haslo;
    }


    @Override
    public void setDane() {

    }
}
