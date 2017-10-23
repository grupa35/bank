package model;

public class Rachunek {

    private long nrB;
    private long stan;
    private IKlient iKlient;

    public long getNrB() {
        return nrB;
    }

    public long getStan() {
        return stan;
    }

    public IKlient getIKlient() {
        return IKlient;
    }

    public void setStan(long stan) {
        this.stan = stan;
    }
}