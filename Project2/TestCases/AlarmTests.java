
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

}
