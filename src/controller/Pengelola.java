package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import model.Admin;
import model.DaftarTransaksi;
import model.Time;
import model.Transaksi;

import java.net.URL;
import java.util.ResourceBundle;

public class Pengelola implements Initializable {


    @FXML
    private Label bulan;

    @FXML
    private Label jam;
    
    @FXML
    private Label cari;

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
    private final ObservableList<Admin> dataList = DaftarTransaksi.getDataAdmin();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        tcNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        tcUsername.setCellValueFactory(new PropertyValueFactory<>("userName"));

//        tvPengelola.setItems(DaftarTransaksi.getDataAdmin());

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
