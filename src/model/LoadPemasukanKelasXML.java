/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Nabil
 */
public class LoadPemasukanKelasXML {

    public static Pemasukan univ ;
    public static void load() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        // TODO code application logic here
        univ = new Pemasukan(0);
        XStream xstream = new XStream(new StaxDriver());
        
        // Proses serialisasi. Objek skul diubah menjadi string dengan format XML
        String sxml = xstream.toXML(univ);
        
        FileOutputStream f = null ; 
        try {
            // membuat nama file tempat simpan xml 
            f = new FileOutputStream("Pemasukan2.xml");
            // mengubah karakter penyusun string xml sebagai bytes (bentuk kode ASCII)
            byte[] bytes = sxml.getBytes("UTF-8");
            // menyimpan file
            f.write(bytes);
        } catch (Exception e) {
            System.out.println("Perhatian: " + e.getMessage());
        }
        finally {
            // menutup file 
            if (f!= null) {
                try {
                    f.close();
                }catch (IOException e) {
                    e.printStackTrace();
                    }
            } 
            
        }
        System.out.println("Data Pemasukan2 berhasil dimuat");
        Pemasukan.total = univ.getTotal();
    }
    
}
