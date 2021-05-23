
import org.junit.Before;
import org.junit.Test;
import sample.MyAlarm;

import static org.junit.Assert.*;

public class AlarmTests {
    MyAlarm test;


    @Before
    public void setup (){
        String name = "food";
        int hour = 1;
        int minute = 5;
        test = new MyAlarm(name, hour, minute);
    }

    @Test
    public void testAlarmPadding1(){
        assertTrue(test.toString().length() == 22);
        assertTrue(test.toString().equals("Alarm for: food  01:05"));
    }

    @Test
    public void testAlarmPadding2(){
        test.hour = 12;
        test.minute = 5;
        assertTrue(test.toString().length() == 22);
        assertTrue(test.toString().equals("Alarm for: food  12:05"));
    }

    @Test
    public void testAlarmPadding3(){
        test.hour = 1;
        test.minute = 50;
        assertTrue(test.toString().length() == 22);
        assertTrue(test.toString().equals("Alarm for: food  01:50"));
    }

    @Test
    public void testAlarmPadding4(){
        test.hour = 12;
        test.minute = 50;
        assertTrue(test.toString().length() == 22);
        assertTrue(test.toString().equals("Alarm for: food  12:50"));
    }

}
