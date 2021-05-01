import org.junit.Before;
import org.junit.Test;
import sample.MyTimer;

import static org.junit.Assert.*;

public class TimerTests{
    MyTimer test;


    @Before
    public void setUp(){
        int length = 2;
        String name = "food";

        test = new MyTimer(name, length);
    }

    @Test
    public void testCountDown(){
        assertEquals(test.timeLeft, 120);
        test.decrement();
        assertEquals(test.timeLeft, 119);
    }

    @Test
    public void testIsDone(){
        assertFalse(test.isDone());
        for (int i = 120; i > 0; i--){
            test.decrement();
        }
        assertTrue(test.isDone());
    }
}
