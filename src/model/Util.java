package model;

import java.text.NumberFormat;
import java.util.Locale;

public class Util {

    public static Locale myIndonesianLocale = new Locale("in", "ID");
    public static NumberFormat formater = NumberFormat.getCurrencyInstance(myIndonesianLocale);
}
