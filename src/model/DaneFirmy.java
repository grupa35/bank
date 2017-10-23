package model;

public class DaneFirmy implements IDane {
    private String nazwa;
    private String adres;
    private long NIP;

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public long getNIP() {
        return NIP;
    }

    public void setNIP(long NIP) {
        this.NIP = NIP;
    }

    @Override
    public String toString() {
        return "nazwa=" + nazwa +
                ", adres=" + adres + 
                ", NIP=" + NIP +
                '}';
    }
}
