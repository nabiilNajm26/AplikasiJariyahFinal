package model;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SimpanPemasukanKelas {
    public static void simpan() throws FileNotFoundException {
        Pemasukan univ = new Pemasukan(0);
        XStream xstream = new XStream(new StaxDriver());

        FileInputStream f = null ;
        try {

            f = new FileInputStream("Pemasukan2.xml");

            int isi; // menyimpan kode angka ASCII yang dibaca dari file
            char c ;
            String sxml = "";

            // membaca file per karakter
            while ((isi = f.read()) != -1) {
                c = (char) isi;
                sxml = sxml + c;
            }

            univ = (Pemasukan) xstream.fromXML(sxml);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        System.out.println("Data Pemasukan2 berhasil disimpan");
    }
}
