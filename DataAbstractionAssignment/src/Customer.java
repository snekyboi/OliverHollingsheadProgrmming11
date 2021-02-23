import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Customer {
    private int accountNumber;
    static int nextAccountID = 1;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    public double getCheckBalance() {
        return checkBalance;
    }

    public void setCheckBalance(double checkBalance) {
        this.checkBalance = checkBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public int depositCount(){
        return deposits.size();
    }

    public int withdrawsCount(){
        return withdraws.size();
    }
    Customer(){
        //create default constructor
        this.accountNumber = nextAccountID;
        nextAccountID++;
    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
        this.deposits = new ArrayList<>();
        this.withdraws = new ArrayList<>();

    }


    // Requires: double, date and string
    // Modifies: account balance
    // Effects: increases the balance of the account by making a deposit
    public double deposit(double amt, Date date, String account){
        if(amt <= 0){
            return 0;
        }
        //System.out.println("Check1 " + checkBalance);
        //System.out.println("Saving1 " + savingBalance);

        if (!date.before(new Date())){
            return 0;
        }
        //System.out.println("Check2 " + checkBalance);
        //System.out.println("Saving2 " + savingBalance);

        if (!account.equals(CHECKING) && !account.equals(SAVING)){
            return 0;
        }
        //System.out.println("Check3 " + checkBalance);
        //System.out.println("Saving3 " + savingBalance);

        Deposit dep1 = new Deposit(amt, date, account);
        deposits.add(dep1);

        if(account == CHECKING){
           checkBalance = checkBalance + amt;
        }
        else if(account == SAVING){
            savingBalance = savingBalance + amt;
        }
        //System.out.println("Check " + checkBalance);
        //System.out.println("Saving " + savingBalance);

        if (account == CHECKING){
            return checkBalance;
        }
        else if(account == SAVING){
            return savingBalance;
        }
        return 0;
    }
    // Requires: double ,date and string
    // Modifies: account balance
    // Effects: decreases the balance of the account by making a withdraw
    public double withdraw(double amt, Date date, String account){
        if (amt <= 0){
            return 0;
        }

        if (!date.before(new Date())){
            return 0;
        }


        if (!account.equals(CHECKING) && !account.equals(SAVING)){
            return 0;
        }

        checkOverdraft(amt, account);

        Withdraw with1 = new Withdraw(amt, date, account);
        withdraws.add(with1);

        if(account == CHECKING){
            checkBalance = checkBalance - amt;
        }
        else if(account == SAVING){
            savingBalance = savingBalance - amt;
        }

        if (account == CHECKING){
            return checkBalance;
        }
        else if(account == SAVING){
            return savingBalance;
        }
        return 0;
    }
    // Requires: amt and account
    // Modifies: nothing
    // Effects: returns false if you are trying to withdraw a valid amount
    // (less than or equal to your account balance)
    private boolean checkOverdraft(double amt, String account){
        if (account.equals(CHECKING)) {
            if (amt > checkBalance){
            }
        }
        if (account.equals(SAVING)) {
            if (amt > savingBalance){
            }
        }

            return false;
    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

}
