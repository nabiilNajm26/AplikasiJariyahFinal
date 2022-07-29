package model;

public class Pengguna {

    private int totalDonasi ;

    private int nomor ;



    public Pengguna( int totalDonasi, int nomor) {
        this.totalDonasi = totalDonasi;
        this.nomor = nomor;
    }

    public int getTotalDonasi() {
        return totalDonasi;
    }

    public void setTotalDonasi(int totalDonasi) {
        this.totalDonasi = totalDonasi;
    }

    public int getNomor() {
        return nomor;
    }

    public void setNomor(int nomor) {
        this.nomor = nomor;
    }
}
