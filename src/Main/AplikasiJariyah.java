/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.*;
import java.io.IOException;

/**
 *
 * @author Nabil
 */
public class AplikasiJariyah extends Application {

    private double x,y ;
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../view/StartPage.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Jariyah");
        stage.getIcons().add(new Image("Mosque.png"));

        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);

        });
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        OpenXMLTransaksi.loadDataTransaksi();
        OpenXMLDaftarPemasukan.loadPemasukan();
        OpenXMLDaftarPemasukan.loadPengeluaran();
        OpenXMLDaftarPemasukan.loadDataAdmin();
        OpenXMLDaftarPemasukan.loadBooleanAdmin();
        OpenXMLDaftarPemasukan.loadCalonAdmin();

        System.out.println(DaftarPemasukan.getTotalPemasukan());


        try {
            launch(args);

        } catch (NullPointerException e) {
            System.out.println("NULL POINTER E");
        }


    }
    
}
