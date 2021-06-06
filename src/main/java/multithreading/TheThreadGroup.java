package multithreading;

import java.util.Timer;
import java.util.TimerTask;

public class TheThreadGroup {

    public static void main(String[] args){

        ThreadGroup threadGroup=new ThreadGroup("group1");

        Thread t1=new Thread(threadGroup,new Worker(1),"1");
        Thread t2=new Thread(threadGroup,new Worker(2),"2");
        Thread t3=new Thread(threadGroup,new Worker(3),"3");

        t1.start();
        t3.start();
        t2.start();

        threadGroup.getName();
        threadGroup.list();

        System.out.println("Suspending Group");
        threadGroup.suspend();

        Timer timer=new Timer();
        timer.schedule(new Watcher(threadGroup,timer),1000,1000);
    }

    static class Watcher extends TimerTask{

        ThreadGroup threadGroup;
        Timer timer;
        int seconds;

        public Watcher(ThreadGroup threadGroup, Timer timer) {

            this.threadGroup=threadGroup;
            this.timer=timer;
        }

        @Override
        public void run() {

            seconds++;

            System.out.println("Suspended after "+seconds+" seconds.");

           if(seconds==10){
               System.out.println("Resuming after "+seconds+" seconds.");
               threadGroup.resume();
               timer.cancel();
           }
        }
    }
}


