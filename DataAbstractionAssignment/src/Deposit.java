import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    // Requires: double, date and string
    // Modifies: nothing
    // Effects: creates a Deposit
    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    // Effects: returns a string about the deposit
    public String toString(){
        //your code here
        return "Deposit of: $" + amount + " Date: " + date + " into account " + account;
    }
}
