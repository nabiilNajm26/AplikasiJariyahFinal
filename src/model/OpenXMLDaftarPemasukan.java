package model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import javafx.collections.ObservableList;

import java.io.FileInputStream;
import java.io.IOException;

public class OpenXMLDaftarPemasukan {

    public static void loadPemasukan(){
        XStream xstream = new XStream(new StaxDriver());

        FileInputStream f = null;

        try{
            f =  new FileInputStream("PemasukanPemasukan.xml");



            int isi;

            char c;
            String sxml = "";


            while((isi = f.read()) != -1){
                c = (char) isi;
                sxml = sxml + c;
            }


//            DaftarPemasukan.setData((ObservableList<Pemasukan>) xstream.fromXML(sxml));
            DaftarTransaksi.setDataPemasukan((ObservableList<Transaksi>) xstream.fromXML(sxml));





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
        System.out.println("Berhasil loading daftar Pemasukan");
    }

    public static void loadPengeluaran(){
        XStream xstream = new XStream(new StaxDriver());

        FileInputStream f = null;

        try{
            f =  new FileInputStream("PengeluaranPengeluaran.xml");



            int isi;

            char c;
            String sxml = "";


            while((isi = f.read()) != -1){
                c = (char) isi;
                sxml = sxml + c;
            }


//            DaftarPemasukan.setData((ObservableList<Pemasukan>) xstream.fromXML(sxml));
            DaftarTransaksi.setDataPengeluaran((ObservableList<Transaksi>) xstream.fromXML(sxml));






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
        System.out.println("Berhasil loading daftar Pengeluaran");
    }

    public static void loadDataAdmin(){
        XStream xstream = new XStream(new StaxDriver());

        FileInputStream f = null;

        try{
            f =  new FileInputStream("DataAdmin.xml");



            int isi;

            char c;
            String sxml = "";


            while((isi = f.read()) != -1){
                c = (char) isi;
                sxml = sxml + c;
            }


//            DaftarPemasukan.setData((ObservableList<Pemasukan>) xstream.fromXML(sxml));
            DaftarTransaksi.setDataAdmin((ObservableList<Admin>) xstream.fromXML(sxml));






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
        System.out.println("Berhasil loading data Admin");
    }


    public static void loadBooleanAdmin(){
        XStream xstream = new XStream(new StaxDriver());

        FileInputStream f = null;

        try{
            f =  new FileInputStream("BooleanAdmin.xml");



            int isi;

            char c;
            String sxml = "";


            while((isi = f.read()) != -1){
                c = (char) isi;
                sxml = sxml + c;
            }


//            DaftarPemasukan.setData((ObservableList<Pemasukan>) xstream.fromXML(sxml));
            DaftarTransaksi.setSudahAdaAdmin((booleanAdmin) xstream.fromXML(sxml));






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
        System.out.println("Berhasil loading BooleanAdmin");
    }

    public static void loadCalonAdmin(){
        XStream xstream = new XStream(new StaxDriver());

        FileInputStream f = null;

        try{
            f =  new FileInputStream("CalonAdmin.xml");



            int isi;

            char c;
            String sxml = "";


            while((isi = f.read()) != -1){
                c = (char) isi;
                sxml = sxml + c;
            }


            DaftarTransaksi.setCalonAdmin((ObservableList<Admin>) xstream.fromXML(sxml));






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
        System.out.println("Berhasil loading CalonAdmin");
    }



}
