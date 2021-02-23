import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    // Requires: nothing
    // Modifies: nothing
    // Effects: decreases the the balance of the account by making a withdraw
    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    // Requires: nothing
    // Modifies: nothing
    // Effects: returns a string about the withdrawal
    public String toString(){
        return "Withdrawal of: $" + amount + " Date: " + date + " from account " + account;
    }
}
