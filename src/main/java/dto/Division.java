package dto;

public class Division {

    private String uid;
    private int dividiendo;
    private int divisor;

    public Division(String uid, int dividiendo, int divisor) {
        this.uid = uid;
        this.dividiendo = dividiendo;
        this.divisor = divisor;
    }

    public Division(){

    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getDividiendo() {
        return dividiendo;
    }

    public void setDividiendo(int dividiendo) {
        this.dividiendo = dividiendo;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }
}

