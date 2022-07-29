package model;

import java.util.Date;




public class Transaksi {

    private  String tanggal;
    private  String transaksi;
    private  String nominal;

    private int nominalPemasukanInt;

    private int nominalPengeluaranInt ;
    private  String jenis;

    private String Nomor;
    String a = String.valueOf(new Date());

    public Transaksi(String nomor,String transaksi, String nominal, String jenis, int nominalInt, int nominalKeluar) {
        this.tanggal = a.substring(8, 10) + a.substring(3, 8)+a.substring(24);
        this.transaksi = transaksi;
        this.nominal = nominal;
        this.jenis = jenis;
        this.Nomor = nomor ;
        this.nominalPemasukanInt = nominalInt;
        this.nominalPengeluaranInt = nominalKeluar;

    }

    public String getTanggal() {
        return tanggal;
    }

    public String getTransaksi() {
        return transaksi;
    }

    public String getNominal() {
        return nominal;
    }

    public String getJenis() {
        return jenis;
    }

    public String getNomor() {
        return Nomor;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setTransaksi(String transaksi) {
        this.transaksi = transaksi;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setNomor(String nomor) {
        Nomor = nomor;
    }

    public int getNominalPemasukanInt() {
        return nominalPemasukanInt;
    }

    public void setNominalPemasukanInt(int nominalPemasukanInt) {
        this.nominalPemasukanInt = nominalPemasukanInt;
    }

    public int getNominalPengeluaranInt() {
        return nominalPengeluaranInt;
    }

    public void setNominalPengeluaranInt(int nominalPengeluaranInt) {
        this.nominalPengeluaranInt = nominalPengeluaranInt;
    }
}
