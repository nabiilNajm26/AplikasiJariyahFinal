package controller;

import com.jfoenix.controls.JFXRadioButton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Duration;


import javafx.fxml.FXML;
import model.*;


public class PembelianC implements Initializable {

    private Stage stage;
    @FXML
    private Label bulan;

    @FXML
    private DatePicker dpTanggal;

    @FXML
    private Label jam;

    @FXML
    private TableColumn<Transaksi, String> tcNominal;

    @FXML
    private TableColumn<Transaksi, String> tcNomor;

    @FXML
    private TableColumn<Transaksi, String> tcTgl;

    @FXML
    private TableColumn<Transaksi, String > tcJenis;

    @FXML
    private TableColumn<Transaksi, String> tcTransaksi;

    @FXML
    private TextField tfNominal;

    @FXML
    private TextField tfTransaksi;

    @FXML
    private TableView<Transaksi> tvPembelian;

    @FXML
    private TextField tfJenis ;

    @FXML
    private JFXRadioButton rbPemasukan;

    @FXML
    private JFXRadioButton rbPengeluaran;

    @FXML
    public void tambah(ActionEvent event) {

        try {
            String jenis = "" ;

            if (rbPemasukan.isSelected()) {
                jenis = "Pemasukan" ;
            } else if (rbPengeluaran.isSelected()) {
                jenis = "Pengeluaran" ;
            }
            int nominal = Integer.parseInt(tfNominal.getText());




            String nominalStr = Util.formater.format(nominal);


            if (jenis.equals("Pemasukan")) {

                DaftarTransaksi.tambah(tfTransaksi.getText(),nominalStr,jenis,nominal,0);
                DaftarTransaksi.setJumlahDonasi(DaftarTransaksi.getJumlahDonasi() + 1);
                tfTransaksi.setText("");
                tfNominal.setText("");
                DaftarPemasukan.tambah(nominal);
                System.out.println(DaftarPemasukan.getTotalPemasukan());
            } else if (jenis.equals("Pengeluaran")) {

                DaftarTransaksi.tambah(tfTransaksi.getText(),nominalStr,jenis,0,nominal);
                tfTransaksi.setText("");
                tfNominal.setText("");
                DaftarPengeluaran.tambah(nominal);
            } else if (!rbPengeluaran.isSelected() && !rbPengeluaran.isSelected()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Perhatian");
                alert.setHeaderText("Isian data belum lengkap!");
                alert.setContentText("Jenis Transaksi harus diisi!!!");
                alert.showAndWait();
            }

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Perhatian");
            alert.setHeaderText("Tipe data isian salah!");
            alert.setContentText("Nominal harus berupa angka!!!");
            alert.showAndWait();
        } catch (NullPointerException e) {
            System.out.println("GPP SAY");
        }


    }

    Time time = new Time();


    @FXML
    public void hapus (ActionEvent event){
        try {
            int selectedID = tvPembelian.getSelectionModel().getSelectedIndex();
            System.out.println("Selected ID: " + selectedID);
            String jenisTransaksi = tvPembelian.getItems().get(selectedID).getJenis();
            System.out.println("Jenis transaksi : " +jenisTransaksi);
            if(jenisTransaksi.equals("Pemasukan")){
                String id = String.valueOf(tvPembelian.getItems().get(selectedID).getNomor()) ;
                int index = DaftarTransaksi.cariIndexMasuk(id);
                DaftarTransaksi.getDataPemasukan().remove(index);
                SimpanXML.simpanKeXML(DaftarTransaksi.getData(),"Transaksi.xml");
                SimpanXML.simpanKeXML(DaftarTransaksi.getDataPemasukan(),"PemasukanPemasukan.xml");
            } else if (jenisTransaksi.equals("Pengeluaran")){
                String id = String.valueOf(tvPembelian.getItems().get(selectedID).getNomor()) ;
                int index = DaftarTransaksi.cariIndexKeluar(id);
                DaftarTransaksi.getDataPengeluaran().remove(index);
                SimpanXML.simpanKeXML(DaftarTransaksi.getData(),"Transaksi.xml");
                SimpanXML.simpanKeXML(DaftarTransaksi.getDataPengeluaran(),"PengeluaranPengeluaran.xml");
            }
            tvPembelian.getItems().remove(selectedID);
            SimpanXML.simpanKeXML(DaftarTransaksi.getData(),"Transaksi.xml");
        } catch (NullPointerException e) {
            System.out.println("GPP SAY");
        }

    }

    @FXML
    void nomorOnEdit(TableColumn.CellEditEvent<Transaksi,String> nomorStringCellEditEvent) {
        Transaksi transaksi = tvPembelian.getSelectionModel().getSelectedItem();
        transaksi.setNomor(nomorStringCellEditEvent.getNewValue());

        String jenis = transaksi.getJenis();

    }

    @FXML
    void transaksiOnEdit(TableColumn.CellEditEvent<Transaksi,String> transaksiStringCellEditEvent) {
        Transaksi transaksi = tvPembelian.getSelectionModel().getSelectedItem();
        transaksi.setTransaksi(transaksiStringCellEditEvent.getNewValue());
        SimpanXML.simpanKeXML(DaftarTransaksi.getData(),"Transaksi.xml");
    }
    @FXML
    void jenisOnEdit(TableColumn.CellEditEvent<Transaksi,String> jenisStringCellEditEvent) {
        Transaksi transaksi = tvPembelian.getSelectionModel().getSelectedItem();
        transaksi.setJenis(jenisStringCellEditEvent.getNewValue());
        SimpanXML.simpanKeXML(DaftarTransaksi.getData(),"Transaksi.xml");
    }

    @FXML
    void nominalOnEdit(TableColumn.CellEditEvent<Transaksi,String> nominalStringCellEditEvent) {
        try {
            Transaksi transaksi = tvPembelian.getSelectionModel().getSelectedItem();

            String jenis = transaksi.getJenis();
            System.out.println("Jenis : " + jenis);
            int indeksMasuk = 0;
            int indeksKeluar = 0;

            if (jenis.equals("Pemasukan")) {
                indeksMasuk = DaftarTransaksi.cariIndexMasuk(String.valueOf(transaksi.getNomor()));
            } else if (jenis.equals("Pengeluaran")) {
                indeksKeluar = DaftarTransaksi.cariIndexKeluar(String.valueOf(transaksi.getNomor()));
            }

            int nominalInt2 = Integer.parseInt(nominalStringCellEditEvent.getNewValue()) ;
            String nominalStr = Util.formater.format(nominalInt2);
            if (jenis.equals("Pemasukan")) {
                transaksi.setNominalPemasukanInt(nominalInt2);
                DaftarTransaksi.getDataPemasukan().get(indeksMasuk).setNominal(nominalStr);
                DaftarTransaksi.getDataPemasukan().get(indeksMasuk).setNominalPemasukanInt(nominalInt2);
            } else if (jenis.equals("Pengeluaran")) {
                DaftarTransaksi.getDataPengeluaran().get(indeksKeluar).setNominal(nominalStr);
                DaftarTransaksi.getDataPengeluaran().get(indeksKeluar).setNominalPengeluaranInt(nominalInt2);
                transaksi.setNominalPengeluaranInt(nominalInt2);


            }


            transaksi.setNominal(nominalStr);
            SimpanXML.simpanKeXML(DaftarTransaksi.getData(),"Transaksi.xml");
            SimpanXML.simpanKeXML(DaftarTransaksi.getDataPemasukan(),"PemasukanPemasukan.xml");
            SimpanXML.simpanKeXML(DaftarTransaksi.getDataPengeluaran(),"PengeluaranPengeluaran.xml");
            tvPembelian.setItems(DaftarTransaksi.getData());
            tcNominal.setCellFactory(TextFieldTableCell.forTableColumn());



        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Perhatian");
            alert.setHeaderText("Format isian nominal salah!");
            alert.setContentText("Mohon edit dengan angka tanpa titik (ex 1000 , 2423)!!!");
            alert.showAndWait();
        }

    }


    @FXML
    void tglOnEdit(TableColumn.CellEditEvent<Transaksi,String> tglCellEditEvent) {
        Transaksi transaksi = tvPembelian.getSelectionModel().getSelectedItem();
        transaksi.setTanggal(tglCellEditEvent.getNewValue());
        SimpanXML.simpanKeXML(DaftarTransaksi.getData(),"Transaksi.xml");
    }
    Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(0.5),
                    e -> {
                        jam.setText(time.oneSecondPassed());
                        bulan.setText(time.getMonth());
                    }
            )
    );


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO code application logic here


        jam.setText(time.oneSecondPassed());
        bulan.setText(time.getMonth());
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();



        tcJenis.setCellValueFactory(new PropertyValueFactory<>("Jenis"));
        tcTgl.setCellValueFactory(new PropertyValueFactory<>("Tanggal"));
        tcTransaksi.setCellValueFactory(new PropertyValueFactory<>("Transaksi"));
        tcNominal.setCellValueFactory(new PropertyValueFactory<>("Nominal"));
        tcNomor.setCellValueFactory(new PropertyValueFactory<>("Nomor"));

        // agar tv bisa diedit
        tvPembelian.setEditable(true);
        // edit transaksi
        tcTransaksi.setCellFactory(TextFieldTableCell.forTableColumn());
        // nominal
        tcNominal.setCellFactory(TextFieldTableCell.forTableColumn());
        // Tgl
        tcTgl.setCellFactory(TextFieldTableCell.forTableColumn());
        // jenis
        tcJenis.setCellFactory(TextFieldTableCell.forTableColumn());
        tvPembelian.setItems(DaftarTransaksi.getData());


    }

}

