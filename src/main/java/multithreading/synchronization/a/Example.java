package multithreading.synchronization.a;

import static java.lang.Thread.currentThread;

public class Example {

    public static void main(String[] args){

        iCounter counter = new iCounter();

        Thread  worker1 = new iCounterThread(counter);
        Thread  worker2 = new iCounterThread(counter);

        worker1.start();
        worker2.start();
    }
}

class iCounter{

   long count = 0;

   public synchronized void add(long value){
       count += value;
       System.out.println(currentThread()+"value->"+value+",iCount->"+count);
   }
}

 class iCounterThread extends Thread{

    protected iCounter counter = null;

    public iCounterThread(iCounter counter){
        this.counter = counter;
    }

    public void run() {
        for(int i=0; i<10; i++){
            counter.add(i);
        }
    }
}