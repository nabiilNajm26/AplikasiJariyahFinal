package model;

public class Pengeluaran {
    int nominal ;

    public static int total ;
    public Pengeluaran(int nominal) {
        this.nominal = nominal;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }
}
