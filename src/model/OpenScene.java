/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package model;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Nabil
 */
public class OpenScene {
    private Pane halaman ;


    public Pane getPane (String fileName) {
        try {

            URL fileHalaman = Main.AplikasiJariyah.class.getResource("/view/"+fileName+".fxml");
            System.out.println(fileHalaman);
            if(fileHalaman == null) {
                throw new java.io.FileNotFoundException("Halaman tidak ditemukan");
            }
            halaman = new FXMLLoader().load(fileHalaman);
        } catch (Exception e) {
            System.out.println("Tidak ditemukan halaman tersebut.");
        }
        return halaman ;
    }



}
