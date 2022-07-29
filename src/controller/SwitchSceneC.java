/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import model.*;

/**
 * FXML Controller class
 *
 * @author Nabil
 */
public class SwitchSceneC implements Initializable {

    /**
     * Initializes the controller class.
     */

    public String bstyle=String.format("-fx-background-color: #009099;");
    public String astyle=String.format("style");

    private Stage stage;

   @FXML
    private LineChart<?, ?> AliranKas;
   
    @FXML
    private Label bulan;

    @FXML
    private DatePicker dpTanggal;

    @FXML
    private Label jam;

    @FXML
    private Button btnAcara;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnKeluar;

    @FXML
    private Button btnLaporan;

    @FXML
    private Button btnPengaturan;

    @FXML
    private Button btnTransaksi;

    @FXML
    private AnchorPane hal;

    

    @FXML
    private BorderPane mainPane;

    @FXML
    private AnchorPane secPane;


    @FXML
    private TableView tvJadwal;
    
    @FXML
    private TableColumn tcAcara;
    
    @FXML
    private TableColumn tcTanggal;
    
        ObservableList jd = observableArrayList (
            new Acara("Pengajian Bulanan","14-12-2022"),
            new Acara("Kajian Hadist","12-12-2022"),
            new Acara("Idul Adha 1435 H","10-06-2022"),
                new Acara("Pemotongan hewan kurban","10-06-2022")

    );


    

    @FXML
    private VBox vbTransaksi;
    
    @FXML
    private VBox vbKanan;

    @FXML
    private Label labelPemasukan , labelPengeluaran;
    
    @FXML
    private Label labelSaldo ;

    @FXML
    private Label labelJumlahDonasi;

    @FXML
    private Label labelJumPengeluaran ;

    @FXML
    public TableColumn<?, ?> tcNomorPemasukan;

    @FXML
    public TableColumn<?, ?> tcNomorPengeluaran;

    @FXML
    public TableColumn<?, ?> tcPemasukanD;

    @FXML
    public TableColumn<?, ?> tcPengeluaranD;

    @FXML
    public TableView<Transaksi> tvPemasukanD;

    @FXML
    public TableView<Transaksi> tvPengeluaranD;

    @FXML
    private Label labelNama;

    @FXML
    private BarChart bcDashBoard ;



    @FXML
    XYChart.Series<String,Integer> data = new XYChart.Series<>();
    
    
    Time time = new Time();
    
    Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(0.5),
                    e -> {
                        jam.setText(time.oneSecondPassed());
                        bulan.setText(time.getMonth());
                    }
            )
    );





    public void keHalamanUtama(MouseEvent event) {
        //ganti warna button
        btnDashboard.setStyle(bstyle);
        btnTransaksi.setStyle(astyle);
        btnLaporan.setStyle(astyle);
        btnCustomers.setStyle(astyle);
        btnAcara.setStyle(astyle);
        btnPengaturan.setStyle(astyle);
        btnKeluar.setStyle(astyle);

        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("HomeFixPakeIni2");
        
        String pemasukanStr = Util.formater.format(DaftarTransaksi.getTotalPemasukan());
        String pengeluaranStr = Util.formater.format(DaftarTransaksi.getTotalPengeluaran());
        labelPemasukan.setText(pemasukanStr);
        labelPengeluaran.setText(pengeluaranStr);
        String saldoStr = Util.formater.format((DaftarTransaksi.getTotalPemasukan() - DaftarTransaksi.getTotalPengeluaran()));
        labelSaldo.setText(saldoStr);
        labelJumlahDonasi.setText(String.valueOf(DaftarTransaksi.getJumlahPemasukan()));
        labelJumPengeluaran.setText(String.valueOf(DaftarTransaksi.getDataPengeluaran().size()));
        labelNama.setText(DaftarTransaksi.adminSkrg.getNama());

        data.getData().get(0).setYValue(DaftarTransaksi.getTotalPemasukan());
        data.getData().get(1).setYValue(DaftarTransaksi.getTotalPengeluaran());
        mainPane.setCenter(hal);
        mainPane.setRight(vbKanan);

        tvPemasukanD.refresh();
        tvPengeluaranD.refresh();


    }

    @FXML
    public void kePembelian(MouseEvent event) {
        btnDashboard.setStyle(astyle);
        btnTransaksi.setStyle(bstyle);
        btnLaporan.setStyle(astyle);
        btnCustomers.setStyle(astyle);
        btnAcara.setStyle(astyle);
        btnPengaturan.setStyle(astyle);
        btnKeluar.setStyle(astyle);
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("Pembelian2");
        mainPane.setCenter(halaman);
        mainPane.setRight(null);
    }

    @FXML
    private void kePencarian(MouseEvent event) {
        btnDashboard.setStyle(astyle);
        btnTransaksi.setStyle(astyle);
        btnLaporan.setStyle(bstyle);
        btnCustomers.setStyle(astyle);
        btnAcara.setStyle(astyle);
        btnPengaturan.setStyle(astyle);
        btnKeluar.setStyle(astyle);
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("Pencarian");
        mainPane.setCenter(halaman);
        mainPane.setRight(null);
    }

    @FXML
    private void kePengelola(MouseEvent event) {
        btnDashboard.setStyle(astyle);
        btnTransaksi.setStyle(astyle);
        btnLaporan.setStyle(astyle);
        btnCustomers.setStyle(bstyle);
        btnAcara.setStyle(astyle);
        btnPengaturan.setStyle(astyle);
        btnKeluar.setStyle(astyle);
        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("Pengelola");
        mainPane.setCenter(halaman);
        mainPane.setRight(null);
    }

    @FXML
    private void keKonfirmasiAdminBaru(MouseEvent event) {
        btnDashboard.setStyle(astyle);
        btnTransaksi.setStyle(astyle);
        btnLaporan.setStyle(astyle);
        btnCustomers.setStyle(astyle);
        btnAcara.setStyle(bstyle);
        btnPengaturan.setStyle(astyle);
        btnKeluar.setStyle(astyle);

        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("Konfirmasi");
        mainPane.setCenter(halaman);
        mainPane.setRight(null);
    }

    @FXML
    private void kePengaturan(MouseEvent event) {
        btnDashboard.setStyle(astyle);
        btnTransaksi.setStyle(astyle);
        btnLaporan.setStyle(astyle);
        btnCustomers.setStyle(astyle);
        btnAcara.setStyle(astyle);
        btnPengaturan.setStyle(bstyle);
        btnKeluar.setStyle(astyle);

        OpenScene object = new OpenScene();
        Pane halaman = object.getPane("Pengaturan");
        mainPane.setCenter(halaman);
        mainPane.setRight(null);
    }

    @FXML
    void keStartPage(MouseEvent event) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("../view/StartPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);


        stage.show();




    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //        navList.setItems(FXCollections.observableArrayList("Red","Yellow","Blue"));


        // Barchart
        data.getData().add(new XYChart.Data<>("Pemasukan",DaftarTransaksi.getTotalPemasukan()));
        data.getData().add(new XYChart.Data<>("Pengeluaran",DaftarTransaksi.getTotalPengeluaran()));

        tvPemasukanD.setEditable(true);
        tvPengeluaranD.setEditable(true);

        bcDashBoard.getData().add(data);
        // Tabel
        tcNomorPemasukan.setCellValueFactory(new PropertyValueFactory<>("Nomor"));
        tcPemasukanD.setCellValueFactory(new PropertyValueFactory<>("Nominal"));
        tcNomorPengeluaran.setCellValueFactory(new PropertyValueFactory<>("Nomor"));
        tcPengeluaranD.setCellValueFactory(new PropertyValueFactory<>("Nominal"));


        tvPemasukanD.setItems(DaftarTransaksi.getDataPemasukan());
        tvPengeluaranD.setItems(DaftarTransaksi.getDataPengeluaran());



        //acara
        tcAcara.setCellValueFactory(new PropertyValueFactory<Acara,String>("acara"));
        tcTanggal.setCellValueFactory(new PropertyValueFactory<Acara,String>("tanggal"));
        tvJadwal.setItems(jd);

        String pemasukanStr = Util.formater.format(DaftarTransaksi.getTotalPemasukan());
        System.out.println("Total pemasukan : " + pemasukanStr);
        String pengeluaranStr = Util.formater.format(DaftarTransaksi.getTotalPengeluaran());
        System.out.println("Total pengeluaran : " + pengeluaranStr);
        labelPemasukan.setText(pemasukanStr);
        labelPengeluaran.setText(pengeluaranStr);
        String saldoStr = Util.formater.format((DaftarTransaksi.getTotalPemasukan() - DaftarTransaksi.getTotalPengeluaran()));
        labelSaldo.setText(saldoStr);
        labelJumlahDonasi.setText(String.valueOf(DaftarTransaksi.getJumlahPemasukan()));
        System.out.println("Data Pemasukan size : " +(DaftarTransaksi.getDataPemasukan().size()));
        System.out.println("Data Pengeluaran size : " +(DaftarTransaksi.getDataPengeluaran().size()));
        labelJumPengeluaran.setText(String.valueOf(DaftarTransaksi.getDataPengeluaran().size()));
        System.out.println(DaftarPemasukan.getData().size());
        System.out.println("ANDA DISINI");

        System.out.println(DaftarTransaksi.adminSkrg.getNama());
        labelNama.setText(DaftarTransaksi.adminSkrg.getNama());

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();



    }

}
