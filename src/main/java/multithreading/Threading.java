package multithreading;

import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Threading {

    public static void main(String[]args){

        ABC threadABC=new ABC("ABC");

        DEF runnableDEF=new DEF();
        Thread threadDEF=new Thread(runnableDEF,"DEF");

        System.out.println("abc -> "+ threadABC.getState());

        threadABC.start();
        threadDEF.start();

        System.out.println("def -> "+ threadDEF.getState());

        // creating an instance of timer class
        Timer timer = new Timer();

        // creating an instance of task to be scheduled
        TimerTask logger = new Logger(threadABC,threadDEF,timer);
        timer.scheduleAtFixedRate(logger,1000,1000);

    }
}

class Logger extends TimerTask{

    ABC threadABC;
    Thread threadDEF;
    Timer timer;

    public Logger(ABC threadABC, Thread threadDEF, Timer timer) {
        this.threadABC=threadABC;
        this.threadDEF=threadDEF;
        this.timer=timer;
    }

    @Override
    public void run() {

        System.out.println("abc -> "+threadABC.getState()+ " and "+"def -> "+threadDEF.getState());

        if(threadABC.getState()== Thread.State.TERMINATED&&threadDEF.getState()== Thread.State.TERMINATED)
            timer.cancel();
    }
}


class ABC extends Thread {

    public ABC(String abc) {
        super(abc);

        System.out.println(super.getName()+ " initialized.");
    }

    @Override
    public void run() {

        for(int i=1;i<=100;i++){

            if(i>25&&i<76) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else System.out.println(Thread.currentThread()+":"+i);
        }
    }
}

class DEF implements Runnable {

    @Override
    public void run() {

        for(int i=1;i<=100;i++){

            if(i>25&&i<76)System.out.println(currentThread()+":"+i);
            else {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
