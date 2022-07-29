package model;

import javafx.collections.ObservableList;

import java.io.FileNotFoundException;

import static javafx.collections.FXCollections.observableArrayList;

public class DaftarPemasukan {
    private static ObservableList pemasukan = observableArrayList(
    );

    public static int totalitas =0;
    private static final String fileName = "Pemasukan.xml";

    public static ObservableList <Pemasukan> getData () {
        return pemasukan;
    }




    private static int id = pemasukan.size() ;
    public static void setData(ObservableList<Pemasukan> data) {
        DaftarPemasukan.pemasukan = pemasukan;
    }

    public static void tambah (int nominal) {
        try {
            pemasukan.add(new Pemasukan(nominal));
//            Pemasukan.total += nominal;
            SimpanPemasukanKelas.simpan();
            SimpanXML.simpanKeXML(getData(),fileName);
            System.out.println("Berhasil simpan file Pemasukan");
            System.out.println(pemasukan.size());
        } catch (NullPointerException e) {
            System.out.println("NULL");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public static int getTotalPemasukan () {
        int total = 0 ;

        for (int i = 0 ; i <= pemasukan.size() -1 ; i ++) {
            total += getData().get(i).getNominal();
            totalitas += getData().get(i).getNominal();
            System.out.println(getData().get(i).getNominal());
        }

        return total;

    }
}
