/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

/**
 *
 * @author ananda wahyan
 */
public class Pengaturan {
    
    @FXML
    private CheckBox notif;
    
    @FXML
    private Label label;
    
    public void change(ActionEvent event){
        
        if (notif.isSelected()){
            label.setText("On");
        }else{
            label.setText("Off");
        }
        
    }
}
