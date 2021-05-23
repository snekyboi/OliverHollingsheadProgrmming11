package sample;

public class MyTimer {
    public String name;
    public int length;// this is in minutes
    public int timeLeft;// this is in seconds


    public int getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }


    public MyTimer (String n, int l){
        name = n;
        length = l;
        timeLeft = length*60;
    }

    public boolean isDone(){
        return timeLeft <= 0;
    }

    public void decrement(){
        if (!isReallyDone()){
            timeLeft--;
        }
    }

    // i use this to figure out when the timer is done alert should go away
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

    public String toString (){
        int actualTimeLeft = timeLeft;
        if (actualTimeLeft < 0){
            actualTimeLeft = 0;
        }
        return name + "("+ length + "mins)  " +  actualTimeLeft + "secs";
    }
}
