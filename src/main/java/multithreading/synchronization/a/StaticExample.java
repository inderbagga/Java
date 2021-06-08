package multithreading.synchronization.a;

import static java.lang.Thread.currentThread;

public class StaticExample {

    public static void main(String[] args){
        sCounter counterA = new sCounter();
        sCounter counterB = new sCounter();
        
        Thread  worker1 = new sCounterThread(counterA);
        Thread  worker2 = new sCounterThread(counterB);

        worker1.start();
        worker2.start();
    }
}

class sCounter{

   static long sCount = 0;

   public static synchronized void sAdd(long value){
       sCount += value;
       System.out.println(currentThread()+"value->"+value+",sCount->"+sCount);
   }
}

class sCounterThread extends Thread{

    protected sCounter counter = null;

    public sCounterThread(sCounter counter){
        this.counter = counter;
    }

    public void run() {
        for(int i=0; i<10; i++){
            counter.sAdd(i);
        }
    }
}