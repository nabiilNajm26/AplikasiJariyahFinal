/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import javafx.collections.ObservableList;

import java.io.FileOutputStream;
import java.io.IOException;


public class SimpanKeXML {
    
    public static void simpanKeXML(ObservableList data, String fileName){
        XStream xstream = new XStream(new StaxDriver());
        String sxml;
         
        FileOutputStream f = null;
        try{      
            f =  new FileOutputStream(fileName);
           
            sxml = xstream.toXML(data);
            byte[] bytes = sxml.getBytes("UTF-8");
            f.write(bytes);
            
        }catch(Exception e){
            System.out.println("Perhatian:" + e.getMessage());
        }finally{
            if(f != null){
                try{
                    f.close();
                }catch(IOException e){
                    e.printStackTrace();
                }           
            }      
        }
        System.out.println("Berhasil menyimpan data ke " + fileName);
    }


    public static void simpanKeXMLBooleanAdmin(booleanAdmin booleanAdmin, String fileName){
        XStream xstream = new XStream(new StaxDriver());
        String sxml;

        FileOutputStream f = null;
        try{
            f =  new FileOutputStream(fileName);

            sxml = xstream.toXML(booleanAdmin);
            byte[] bytes = sxml.getBytes("UTF-8");
            f.write(bytes);

        }catch(Exception e){
            System.out.println("Perhatian:" + e.getMessage());
        }finally{
            if(f != null){
                try{
                    f.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Berhasil menyimpan data booleanAdmin ke " + fileName);
    }
}
