package sample;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyAlarm {
    public String name;
    public int hour;
    public int minute;

    public MyAlarm (String n, int h, int m){
        name = n;
        hour = h;
        minute = m;
    }

    public void writeToFile(BufferedWriter bw) throws IOException {
        bw.write(name + "\r");
        bw.write(formattedTime() + "\r");
        bw.write(";\r");
    }
    public String toString(){
        return "Alarm for: " + name + "  " + formattedTime();
    }

    public String formattedTime(){
        return String.format("%1$02d:%2$02d", hour, minute);
    }

}
