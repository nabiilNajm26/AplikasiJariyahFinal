package model ;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Muhammad Aufa Asmawy | 20523235
 */
public class Time {

    public Time() {
    }

    public String oneSecondPassed(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now).toString();
    }
    public String getDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy ");
        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now).toString();
    }
    public String getDay(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EE, dd MMMM yyyy ");
        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now).toString();
    }

    public String getMonth(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E ");
        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now).toString();
    }
}
