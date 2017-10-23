package model;

public class DaneOsobowe implements IDane {
    private String imie;
    private String nazwisko;
    private long pesel;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "imie=" + imie +
                ", nazwisko=" + nazwisko +
                ", pesel=" + pesel +
                '}';
    }
}