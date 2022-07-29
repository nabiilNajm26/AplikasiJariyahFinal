package model;

import javafx.collections.ObservableList;

import static javafx.collections.FXCollections.observableArrayList;

public class DaftarPengeluaran {

    private static ObservableList pengeluaran = observableArrayList(
    );



    private static final String fileName = "Pengeluaran.xml";

    public static ObservableList <Pengeluaran> getData () {
        return pengeluaran;
    }




    private static int id = pengeluaran.size() ;
    public static void setData(ObservableList<Pengeluaran> data) {
        DaftarPengeluaran.pengeluaran = pengeluaran;
    }

    public static void tambah (int nominal) {
        try {
            pengeluaran.add(new Pengeluaran(nominal));

            SimpanXML.simpanKeXML(getData(),fileName);
            System.out.println("Berhasil simpan file baru");
            System.out.println(pengeluaran.size());
            Pengeluaran.total += nominal ;
        } catch (NullPointerException e) {
            System.out.println("NULL");
        }


    }
}
