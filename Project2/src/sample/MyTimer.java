package sample;

public class MyTimer {
    public String name;
    public int length;// this is in minutes
    public int timeLeft;// this is in seconds




    public MyTimer (String n, int l){
        name = n;
        length = l;
        timeLeft = length*60;
    }

    //Requires: nothing
    //Modifies: nothing
    // Effects: checks if a timer is done
    public boolean isDone(){
        return timeLeft <= 0;
    }

    //Requires: nothing
    //Modifies: timeLeft
    // Effects: makes the timer's time left decrease
    public void decrement(){
        if (!isReallyDone()){
            timeLeft--;
        }
    }

    //Requires: nothing
    //Modifies: nothing
    // Effects: figures out when the timer is done alert should go away
    public boolean isReallyDone(){
        return timeLeft <= -60;
    }

    /*public void countdown (int length) throws InterruptedException {
        int timerLength = length;
        int i = length;
        for (i = length; i == 0; i--){
            Thread.sleep(60000);
            timeLeft--;
        }
        isDone = true;

    }*/

    //Requires: nothing
    //Modifies: the way the computer sees timers
    // Effects: changes the way the computer sees timers
    public String toString (){
        int actualTimeLeft = timeLeft;
        if (actualTimeLeft < 0){
            actualTimeLeft = 0;
        }
        return name + "("+ length + "mins)  " +  actualTimeLeft + "secs";
    }
}
