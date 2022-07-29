package model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import javafx.collections.ObservableList;
import java.io.FileInputStream;
import java.io.IOException;


public class OpenXMLTransaksi {

    public static void loadDataTransaksi(){
        XStream xstream = new XStream(new StaxDriver());

        FileInputStream f = null;

        try{
            f =  new FileInputStream("Transaksi.xml");



            int isi;

            char c;
            String sxml = "";


            while((isi = f.read()) != -1){
                c = (char) isi;
                sxml = sxml + c;
            }


            DaftarTransaksi.setData((ObservableList<Transaksi>) xstream.fromXML(sxml));






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
        System.out.println("Berhasil loading data transaksi");
    }

}
