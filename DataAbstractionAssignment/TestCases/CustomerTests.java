import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class CustomerTests {
    Customer test;
    
    @Before
    public void setup(){
        test = new Customer("bob", 1, 10.0, 100.0);
    }

    @Test
    public void testCustomer(){
        //Date now = Calendar.set(120, 3, 12,11,11,11);
        Date myDate = new Date();
        //String date = LocalDate.now().toString();
        //System.out.println(test.getCheckBalance());
        test.deposit(15.0, myDate, Customer.CHECKING);
        //System.out.println(test.getCheckBalance());
        assertEquals(test.getCheckBalance(), 25,0.1);
        assertEquals(test.depositCount(), 1);

    }
    @Test
    public void testNegativeAmt(){
        //Date now = Calendar.set(120, 3, 12,11,11,11);
        Date myDate = new Date();
        //String date = LocalDate.now().toString();
        test.deposit(-5.0, myDate, Customer.CHECKING);
        assertEquals(test.getCheckBalance(), 10,0.1);
        assertEquals(test.depositCount(), 0);
    }

    @Test
    public void testFutureDates(){
        //Date now = Calendar.set(120, 3, 12,11,11,11);
        Date myDate = new Date(122,10,14);
        //String date = LocalDate.now().toString();
        test.deposit(10.0, myDate, Customer.CHECKING);
        //assertEquals(test.deposit.myDate, 10,0.1);
        assertEquals(test.depositCount(), 0);
    }

    @Test
    public void testPastDates(){
        //Date now = Calendar.set(120, 3, 12,11,11,11);
        Date myDate = new Date(100,10,14);
        //String date = LocalDate.now().toString();
        test.deposit(10.0, myDate, Customer.CHECKING);
        //assertEquals(test.deposit.myDate, 10,0.1);
        assertEquals(test.depositCount(), 1);
    }

    @Test
    public void testCheckingSaving(){
        //Date now = Calendar.set(120, 3, 12,11,11,11);
        Date myDate = new Date();
        //String date = LocalDate.now().toString();
        test.deposit(10.0, myDate, "Fred");
        assertEquals(test.getCheckBalance(), 10,0.1);
        assertEquals(test.depositCount(), 0);
    }
}
