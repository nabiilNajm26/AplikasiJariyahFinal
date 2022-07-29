package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import model.DaftarTransaksi;
import model.Time;
import model.Transaksi;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;

public class Pencarian implements Initializable {

    // ============================ VIEW : PENCARIAN ====================== //

    @FXML
    private TextField tfCari;

    @FXML
    private Label bulan;

    @FXML
    private Label jam;

    @FXML
    private TableColumn<Transaksi, String> tcJenis;

    @FXML
    private TableColumn<Transaksi, String> tcNominal;

    @FXML
    private TableColumn<Transaksi, String> tcNomor;

    @FXML
    private TableColumn<Transaksi, String> tcTgl;

    @FXML
    private TableColumn<Transaksi, String> tcTransaksi;

    @FXML
    private TableView<Transaksi> tvPembelian;

    private final ObservableList<Transaksi> dataList = DaftarTransaksi.getData();



    @FXML
    void jenisOnEdit(ActionEvent event) {

    }

    @FXML
    void nominalOnEdit(ActionEvent event) {

    }

    @FXML
    void tglOnEdit(ActionEvent event) {

    }

    @FXML
    void transaksiOnEdit(ActionEvent event) {

    }

    Time time = new Time();

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

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        tcJenis.setCellValueFactory(new PropertyValueFactory<>("Jenis"));
        tcTgl.setCellValueFactory(new PropertyValueFactory<>("Tanggal"));
        tcTransaksi.setCellValueFactory(new PropertyValueFactory<>("Transaksi"));
        tcNominal.setCellValueFactory(new PropertyValueFactory<>("Nominal"));
        tcNomor.setCellValueFactory(new PropertyValueFactory<>("Nomor"));

        FilteredList<Transaksi> filteredData = new FilteredList<>(dataList,b->true) ;

        tfCari.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredData.setPredicate(transaksi -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (transaksi.getTransaksi().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (String.valueOf(transaksi.getNomor()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true ;
                } else if (String.valueOf(transaksi.getJenis()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true ;
                } else return false ;
            });

        }));

        SortedList <Transaksi> sortedData = new SortedList<>(filteredData);

        sortedData.comparatorProperty().bind( tvPembelian.comparatorProperty());


        tvPembelian.setItems(sortedData);
    }
}
