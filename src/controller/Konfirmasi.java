package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import model.Admin;
import model.DaftarTransaksi;
import model.SimpanXML;
import model.Time;

import java.net.URL;
import java.util.ResourceBundle;

public class Konfirmasi implements Initializable {
    @FXML
    private Label bulan;

    @FXML
    private Label jam;

    @FXML
    private TableColumn<?, ?> tcNama;

    @FXML
    private TableColumn<?, ?> tcUsername;

    @FXML
    private TextField tfCari;

    @FXML
    private TableView<Admin> tvPengelola;

    Time time = new Time();

    Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(0.5),
                    e -> {
                        jam.setText(time.oneSecondPassed());
                        bulan.setText(time.getMonth());
                    }
            )
    );

    private final ObservableList<Admin> dataList = DaftarTransaksi.getCalonAdmin();

    @FXML
    void terima(ActionEvent event) {


        int selectedID = tvPengelola.getSelectionModel().getSelectedIndex();
        String nama = tvPengelola.getItems().get(selectedID).getNama();

        int indeks = DaftarTransaksi.cariCalonAdmin(nama);

        // Menambah calon Admin ke admin
        DaftarTransaksi.getDataAdmin().add(DaftarTransaksi.getCalonAdmin().get(indeks));
        SimpanXML.simpanKeXML(DaftarTransaksi.getDataAdmin(),DaftarTransaksi.fileAdmin);
        // Menghapus calon Admin
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Sukses!");
        alert.setHeaderText("Admin baru berhasil ditambah!");
        alert.setContentText("Admin " + DaftarTransaksi.getCalonAdmin().get(indeks).getNama() +" sudah bisa login ke Jariyah!!");
        alert.showAndWait();

        DaftarTransaksi.getCalonAdmin().remove(indeks);
        SimpanXML.simpanKeXML(DaftarTransaksi.getCalonAdmin(),DaftarTransaksi.getFileNameCalonAdmin());




    }

    @FXML
    void tolak(ActionEvent event) {
        int selectedID = tvPengelola.getSelectionModel().getSelectedIndex();
        String nama = tvPengelola.getItems().get(selectedID).getNama();

        int indeks = DaftarTransaksi.cariCalonAdmin(nama);

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Sukses!");
        alert.setHeaderText("Admin baru ditolak!");
        alert.setContentText("Admin " + DaftarTransaksi.getCalonAdmin().get(indeks).getNama() +" dihapus dari list!!");
        alert.showAndWait();

        // Menghapus calon Admin
        DaftarTransaksi.getCalonAdmin().remove(indeks);
        SimpanXML.simpanKeXML(DaftarTransaksi.getCalonAdmin(),DaftarTransaksi.getFileNameCalonAdmin());


    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        tcNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        tcUsername.setCellValueFactory(new PropertyValueFactory<>("userName"));

        // Algoritma pencarian
        FilteredList<Admin> filteredData = new FilteredList<>(dataList, b->true) ;

        tfCari.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredData.setPredicate(admin -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (admin.getNama().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (admin.getUserName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true ;
                }else  return false ;
            });

        }));

        SortedList<Admin> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind( tvPengelola.comparatorProperty());


        tvPengelola.setItems(sortedData);
    }
}
