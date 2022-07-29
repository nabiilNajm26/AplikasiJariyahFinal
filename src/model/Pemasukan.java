package model;

public class Pemasukan {
    int nominal ;


    public static int total ;
    public Pemasukan(int nominal) {
        this.nominal = nominal;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public int getTotal() {
        return total;
    }

}
