/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ananda wahyan
 */
public class Acara {
    String acara;
    String tanggal;
    
    public Acara(String x,String y){
        this.acara = x;
        this.tanggal = y;
    }
    public String getNama() {
        return acara;
    }
    public String getKode() {
        return tanggal;
    }

    public String getAcara() {
        return acara;
    }

    public String getTanggal() {
        return tanggal;
    }
    
    
    
    
}
