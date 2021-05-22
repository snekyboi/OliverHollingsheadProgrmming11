package sample;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CurrentTime {

    private static int currentHour;
    private static int currentMinute;

    public CurrentTime(){
        updateTime();
    }
    private Object GregorianCalendar;

    public static void updateTime() {
        Calendar calendar = new GregorianCalendar();
        int actualHour = calendar.get(Calendar.HOUR);
        int actualMinute = calendar.get(Calendar.MINUTE);
        currentHour = actualHour;
        currentMinute = actualMinute;
    }


    public static boolean isDone(MyAlarm a){
        Boolean isDone = false;
        updateTime();
        if (currentHour == a.hour && currentMinute == a.minute) {
            isDone = true;
        }
        System.out.println(currentMinute);
        return isDone;
    }

    public static String toStringTime(){
        return String.format("%1$02d : %2$02d", currentHour, currentMinute);
    }

}
