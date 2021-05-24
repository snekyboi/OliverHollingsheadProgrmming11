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

    //Requires: a BufferedWriter
    //Modifies: a file
    // Effects: writes the info for the alarm
    public void writeToFile(BufferedWriter bw) throws IOException {
        bw.write(name + "\r");
        bw.write(formattedTime() + "\r");
        bw.write(";\r");
    }

    //Requires: nothing
    //Modifies: the way the computer sees alarms
    // Effects: changes the way the computer sees alarms
    public String toString(){
        return "Alarm for: " + name + "  " + formattedTime();
    }

    //Requires: nothing
    //Modifies: what toString returns
    // Effects: pads what toString returns with zeros to make all times the same length
    public String formattedTime(){
        return String.format("%1$02d:%2$02d", hour, minute);
    }

}
