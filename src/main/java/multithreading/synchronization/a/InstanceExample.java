package multithreading.synchronization.a;

import static java.lang.Thread.currentThread;

public class InstanceExample {

    public static void main(String[] args){

        Counter counterA = new Counter();
        Counter counterB = new Counter();

        Thread  worker1 = new CounterThread(counterA);
        Thread  worker2 = new CounterThread(counterB);

        worker1.start();
        worker2.start();
    }
}

 class Counter{

    long count = 0;

    public synchronized void add(long value){
        count += value;
        System.out.println(currentThread()+"value->"+value+",iCount->"+count);
    }
 }

 class CounterThread extends Thread{

    protected Counter counter = null;

    public CounterThread(Counter counter){
        this.counter = counter;
    }

    public void run() {
        for(int i=0; i<10; i++){
            counter.add(i);
        }
    }
}