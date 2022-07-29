package model ;

import javafx.beans.Observable;
import javafx.collections.ObservableList;

import java.util.Random;

import static javafx.collections.FXCollections.observableArrayList;

public class DaftarTransaksi {
    private static ObservableList data = observableArrayList(
    );

    private static ObservableList dataPemasukan = observableArrayList(
    );

    private static ObservableList dataPengeluaran = observableArrayList(
    );

    private static ObservableList dataAdmin = observableArrayList();

    private static ObservableList calonAdmin = observableArrayList();

    public static Admin adminSkrg = new Admin("Default Name","Default Username","Default Password");
    private static final String fileName = "Transaksi.xml";
    private static final String fileNameMasuk = "PemasukanPemasukan.xml";
    private static final String fileNameKeluar = "PengeluaranPengeluaran.xml";

    private static final String fileNameBooleanAdmin = "BooleanAdmin.xml";
    private static final String fileNameCalonAdmin = "CalonAdmin.xml";

    public static String getFileNameCalonAdmin() {
        return fileNameCalonAdmin;
    }

    public static final String fileAdmin = "DataAdmin.xml" ;

    public static ObservableList <Transaksi> getData () {
        return data;
    }

    public static ObservableList <Transaksi> getDataPemasukan () {
        return dataPemasukan;
    }

    public static ObservableList <Transaksi> getDataPengeluaran () {
        return dataPengeluaran;
    }

    public static ObservableList <Admin> getDataAdmin () {
        return dataAdmin;
    }

    public static void setAdminSkrg(Admin adminSkrg) {
        DaftarTransaksi.adminSkrg = adminSkrg;
    }

    public static ObservableList <Admin> getCalonAdmin() {
        return calonAdmin;
    }

    public static void setCalonAdmin(ObservableList <Admin> calonAdmin) {
        DaftarTransaksi.calonAdmin = calonAdmin;
    }

    public static booleanAdmin sudahAdaAdmin = new booleanAdmin(getDataAdmin().size() ==1) ;

    public static booleanAdmin getSudahAdaAdmin() {
        return sudahAdaAdmin;
    }

    public static void setSudahAdaAdmin(booleanAdmin sudahAdaAdmin) {
        DaftarTransaksi.sudahAdaAdmin = sudahAdaAdmin;
        SimpanXML.simpanKeBooleanAdmin(getSudahAdaAdmin(),fileNameBooleanAdmin);

    }

    private static int jumlahDonasi = 0 ;

    private static int id = data.size() ;
    public static void setData(ObservableList<Transaksi> data) {
        DaftarTransaksi.data = data;
    }

    public static void setDataAdmin(ObservableList dataAdmin) {
        DaftarTransaksi.dataAdmin = dataAdmin;
    }

    public static void tambah (String transaksi, String nominal, String jenis, int nominalInt, int nominalKeluar) {
try {
    String id  = random();
    data.add(new Transaksi(id,transaksi,nominal,jenis, nominalInt,nominalKeluar));
    if (nominalInt == 0 ) {

        dataPengeluaran.add(new Transaksi(id,transaksi,nominal,jenis, nominalInt,nominalKeluar));
    } else if (nominalKeluar == 0) {

        dataPemasukan.add(new Transaksi(id,transaksi,nominal,jenis, nominalInt,nominalKeluar));

    }
    SimpanXML.simpanKeXML(getData(),fileName);
    SimpanXML.simpanKeXML(getDataPemasukan(),fileNameMasuk);
    SimpanXML.simpanKeXML(getDataPengeluaran(),fileNameKeluar);
    System.out.println("Berhasil simpan file baru");
    System.out.println(data.size());



} catch (NullPointerException e) {
    System.out.println("NULL");
}



    }

    public static void tambahAdmin(String nama, String userName, String password) {
        dataAdmin.add(new Admin(nama,userName,password)) ;
        SimpanXML.simpanKeXML(getDataAdmin(),fileAdmin);
        SimpanXML.simpanKeBooleanAdmin(getSudahAdaAdmin(),fileNameBooleanAdmin);

    }

    public static void tambahCalonAdmin (String nama, String userName, String password) {
        calonAdmin.add(new Admin(nama,userName,password));
        SimpanXML.simpanKeXML(getCalonAdmin(),fileNameCalonAdmin);
    }

    public static int konfirmasi(String username, String password) {
        for (int i = 0 ;i<= dataAdmin.size()-1 ; i ++) {
            if (username.equals(getDataAdmin().get(i).getUserName()) && password.equals(getDataAdmin().get(i).getPassword())) {
                return i ;
            }
        }
        return -1;
    }


    public static int getTotalPemasukan() {
        int hasil = 0 ;
        for (int i = 0 ; i<= getDataPemasukan().size() - 1 ; i ++) {
            hasil += getDataPemasukan().get(i).getNominalPemasukanInt()  ;
            System.out.println("Pemasukan 1 : " + hasil);

        }
        return hasil ;
    }

    public static int getTotalPengeluaran() {
        int hasil = 0 ;
        for (int i = 0 ; i<= getDataPengeluaran().size() - 1 ; i ++) {
            hasil += getDataPengeluaran().get(i).getNominalPengeluaranInt()  ;
            System.out.println("Pengeluaran 1 : " + hasil);
        }
        return hasil ;
    }

    public static int getJumlahPemasukan () {
        int jml = 0 ;
        for (int i = 0 ; i<= getData().size() - 1 ; i ++) {
            String jenisStr= getData().get(i).getJenis();
            if (jenisStr.equals("Pemasukan")) jml ++ ;
        }
        return jml;

    }


    public static int getJumlahDonasi() {
        return jumlahDonasi;
    }

    public static void setJumlahDonasi(int jumlahDonasi) {
        DaftarTransaksi.jumlahDonasi = jumlahDonasi;
    }

    public static void setDataPemasukan(ObservableList <Transaksi> dataPemasukan) {
        DaftarTransaksi.dataPemasukan = dataPemasukan;
    }

    public static void setDataPengeluaran(ObservableList <Transaksi> dataPengeluaran) {
        DaftarTransaksi.dataPengeluaran = dataPengeluaran;
    }

    public static int cariIndexMasuk(String id) {
        for (int i = 0 ; i<= getDataPemasukan().size() - 1 ; i ++) {
            if (String.valueOf(getDataPemasukan().get(i).getNomor()).equals(id)) {
                return i ;
            }
        }
        return -1 ;
    }

    public static int cariIndexKeluar(String id) {
        for (int i = 0 ; i<= getDataPengeluaran().size() - 1 ; i ++) {
            if (String.valueOf(getDataPengeluaran().get(i).getNomor()).equals(id)) {
                return i ;
            }
        }
        return -1 ;
    }


    public static int cariCalonAdmin(String nama) {
        for (int i = 0 ; i<= getCalonAdmin().size() - 1 ; i ++) {
            if (getCalonAdmin().get(i).getNama().equals(nama)) {
                return i ;
            }
        }
        return -1 ;
    }

    public static String random() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        System.out.println(generatedString);
        return generatedString;
    }




}