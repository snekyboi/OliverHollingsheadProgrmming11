package sample;

class MyTimer {
    public String name;
    public int length;
    public boolean isDone = false;

    public int getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    int timeLeft;


    MyTimer (String n, int l){
        name = n;
        length = l;
        timeLeft = length;

    }

    public void decrement(){
        if(!isDone){
            timeLeft--;
        }
        if(timeLeft == 0){
            isDone = true;
        }
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
        return "Timer for: " + name + "   Total Time: " + length + "  Time Left: " + timeLeft;
    }
}
