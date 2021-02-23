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
    public void testCustomerChecking(){
        //Date now = Calendar.set(120, 3, 12,11,11,11);
        Date myDate = new Date();
        //String date = LocalDate.now().toString();
        System.out.println(test.getCheckBalance());
        double result = test.deposit(15.0, myDate, Customer.CHECKING);
        System.out.println(test.getCheckBalance());
        assertEquals(test.getCheckBalance(), 25,0.1);
        assertEquals(test.depositCount(), 1);
        assertEquals(result, 25, 0.1);
    }

    @Test
    public void testCustomerSaving(){
        //Date now = Calendar.set(120, 3, 12,11,11,11);
        Date myDate = new Date();
        //String date = LocalDate.now().toString();
        System.out.println(test.getSavingBalance());
        double result = test.deposit(15.0, myDate, Customer.SAVING);
        System.out.println(test.getSavingBalance());
        assertEquals(test.getSavingBalance(), 115,0.1);
        assertEquals(test.depositCount(), 1);
        assertEquals(result, 115, 0.1);

    }
    @Test
    public void testNegativeAmt(){
        //Date now = Calendar.set(120, 3, 12,11,11,11);
        Date myDate = new Date();
        //String date = LocalDate.now().toString();
        //System.out.println(test.getSavingBalance());
        double result = test.deposit(-5.0, myDate, Customer.CHECKING);
        //System.out.println(test.getSavingBalance());
        assertEquals(test.getCheckBalance(), 10,0.1);
        assertEquals(test.depositCount(), 0);
        assertEquals(result, 0, 0.1);

    }

    @Test
    public void testFutureDates(){
        //Date now = Calendar.set(120, 3, 12,11,11,11);
        Date myDate = new Date(122,10,14);
        //String date = LocalDate.now().toString();
        double result = test.deposit(10.0, myDate, Customer.CHECKING);
        //assertEquals(test.deposit.myDate, 10,0.1);
        assertEquals(test.depositCount(), 0);
        assertEquals(result, 0, 0.1);

    }

    @Test
    public void testPastDates(){
        //Date now = Calendar.set(120, 3, 12,11,11,11);
        Date myDate = new Date(100,10,14);
        //String date = LocalDate.now().toString();
        double result = test.deposit(10.0, myDate, Customer.CHECKING);
        //assertEquals(test.deposit.myDate, 10,0.1);
        assertEquals(test.depositCount(), 1);
        assertEquals(result, 20, 0.1);

    }

    @Test
    public void testCheckingSaving(){
        //Date now = Calendar.set(120, 3, 12,11,11,11);
        Date myDate = new Date();
        //String date = LocalDate.now().toString();
        double result = test.deposit(10.0, myDate, "Fred");
        assertEquals(test.getCheckBalance(), 10,0.1);
        assertEquals(test.depositCount(), 0);
        assertEquals(result, 0, 0.1);

    }






    @Test
    public void testWithdrawChecking() {
        Date myDate = new Date();
        System.out.println(test.getSavingBalance());
        double result = test.withdraw(1, myDate, Customer.CHECKING);
        System.out.println(test.getSavingBalance());
        assertEquals(test.getCheckBalance(), 9, 0.1);
        assertEquals(test.withdrawsCount(), 1);
        assertEquals(result, 9, 0.1);

    }

    @Test
    public void testWithdrawSaving(){
        Date myDate = new Date();
        System.out.println(test.getSavingBalance());
        double result = test.withdraw(10, myDate, Customer.SAVING);
        System.out.println(test.getSavingBalance());
        assertEquals(test.getSavingBalance(), 90, 0.1);
        assertEquals(test.withdrawsCount(), 1);
        assertEquals(result, 90, 0.1);

    }

    @Test
    public void testWithdrawNegativeAmt(){
        Date myDate = new Date();
        double result = test.withdraw(-5.0, myDate, Customer.CHECKING);
        assertEquals(test.getCheckBalance(), 10,0.1);
        assertEquals(test.withdrawsCount(), 0);
        assertEquals(result, 0, 0.1);


    }

    @Test
    public void testWithdrawFutureDates(){
        Date myDate = new Date(122,10,14);
        double result = test.withdraw(10.0, myDate, Customer.CHECKING);
        assertEquals(test.withdrawsCount(), 0);
        assertEquals(result, 0, 0.1);

    }

    //@Test
   // public void testWithdrawPastDates(){
       // Date myDate = new Date(100,10,14);
       // System.out.println(test.getSavingBalance());
        //double result = test.withdraw(10.0, myDate, Customer.CHECKING);
       // System.out.println(test.getSavingBalance());
       // assertEquals(test.withdrawsCount(), 0);
       // assertEquals(result, 0, 0.1);

    //}

    @Test
    public void testWithdrawCheckingOrSaving(){
        Date myDate = new Date();
        double result = test.withdraw(10.0, myDate, "Fred");
        assertEquals(test.getCheckBalance(), 10,0.1);
        assertEquals(test.withdrawsCount(), 0);
        assertEquals(result, 0, 0.1);

    }

    @Test
    public void testWithdrawToLargeValueChecking(){
        Date myDate = new Date();
        double result = test.withdraw(20.0, myDate, Customer.CHECKING);
        assertEquals(test.getCheckBalance(), 10,0.1);
        assertEquals(test.withdrawsCount(), 0);
        assertEquals(result, 0, 0.1);


    }

    @Test
    public void testWithdrawToLargeValueSaving(){
        Date myDate = new Date();
        double result = test.withdraw(200.0, myDate, Customer.SAVING);
        assertEquals(test.getSavingBalance(), 100,0.1);
        assertEquals(test.withdrawsCount(), 0);
        assertEquals(result, 0, 0.1);


    }

    @Test
    public void testMaxAmount(){
        Date myDate = new Date();
        System.out.println(test.getSavingBalance());
        double result = test.withdraw(100, myDate,Customer.SAVING);
        System.out.println(test.getSavingBalance());
        assertEquals(test.getSavingBalance(), 0, 0.1);
        assertEquals(test.withdrawsCount(), 1);
        assertEquals(result, 0, 0.1);

    }
}
