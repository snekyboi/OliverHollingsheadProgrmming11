package sample;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CurrentTime {

    // Requires: amt and account
    // Modifies: nothing
    // Effects: returns false if you are trying to withdraw a valid amount
    // (less than or equal to your account balance)

    private static int currentHour;
    private static int currentMinute;

    //Requires: nothing
    //Modifies: nothing
    // Effects: calls the function that updates what the label that shows the time says
    public CurrentTime(){
        updateTime();
    }
    private Object GregorianCalendar;

    //Requires: nothing
    //Modifies: the label that shows the time
    // Effects: updates the label that shows the time
    public static void updateTime() {
        Calendar calendar = new GregorianCalendar();
        int actualHour = calendar.get(Calendar.HOUR);
        int actualMinute = calendar.get(Calendar.MINUTE);
        currentHour = actualHour;
        currentMinute = actualMinute;
    }

    //Requires: an alarm
    //Modifies: nothing
    // Effects: checks if an alarm is done
    public static boolean isDone(MyAlarm a){
        Boolean isDone = false;
        updateTime();
        if (currentHour == a.hour && currentMinute == a.minute) {
            isDone = true;
        }
        return isDone;
    }

    //Requires: nothing
    //Modifies: how the computer sees alarms
    // Effects: returns an alarms padded with zeros
    public static String toStringTime(){
        return String.format("%1$02d : %2$02d", currentHour, currentMinute);
    }

}
