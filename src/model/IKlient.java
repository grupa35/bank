package model;

public interface IKlient {

    long getId();
    String getDane();
    String getHaslo();
    void setDane(IDane dane);
    void setHaslo(String pswd);

}
