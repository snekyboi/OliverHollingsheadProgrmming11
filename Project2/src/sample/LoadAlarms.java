package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadAlarms {

    private static String name;
    private static String hour;
    private static int minute;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<MyAlarm> alarms = new ArrayList<>();


    //Requires: a file name
    //Modifies: nothing
    // Effects: reads the file and makes each alarm into it's own string
    public static ArrayList createAllAlarms (String fileName) throws IOException {
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String alarmString = "";
        while ((line = br.readLine()) !=null){
            if (!line.equals(";")){
                alarmString += line + ",";
            }else{
                parseAlarm(alarmString);
                alarmString = "";
            }
        }
        return alarms;
    }


    //Requires: a string
    //Modifies: that string
    // Effects: makes the info from the file into alarms to be put on the ArrayList
    private static void parseAlarm(String string){
        int pos = 0;
        String name = "";
        int hour = 0;
        int minute = 0;
        for (int i = 0; i < string.length(); i++){
            if (string.substring(i, i+1).equals(",")){
                pos = i;
                name = string.substring(0, pos);
                String hourTo = string.substring(pos + 1, pos + 3);
                hour = Integer.parseInt(hourTo);
                String minuteTo = string.substring(pos+4, pos + 6);
                minute = Integer.parseInt(minuteTo);
                break;
            }
        }
        alarms.add(new MyAlarm(name, hour, minute));
    }
}
