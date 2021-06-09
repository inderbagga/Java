package multithreading.synchronization.me.b;

import static java.lang.Thread.currentThread;

public class StaticExclusive {

    public static void main(String[] args){

        Thread worker1=new Thread("worker1"){
            @Override
            public void run() {
                StaticExclusive.printTableStaticMethod(1);
            }
        };

        Thread worker2=new Thread("worker2"){
            @Override
            public void run() {
                StaticExclusive.printTableStaticMethod(2);
            }
        };

        Thread worker3=new Thread("worker3"){
            @Override
            public void run() {
                StaticExclusive.printTableStaticdBlock(3);
            }
        };

        Thread worker4=new Thread("worker4"){
            @Override
            public void run() {
                StaticExclusive.printTableStaticdBlock(4);
            }
        };

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();
    }

    //Use of static Synchronized method
    synchronized static protected void printTableStaticMethod(int number){

        for(int i=1;i<=10;i++){
            System.out.println(currentThread()+"->sMethod"+number*i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //Use of static Synchronized block
    protected static void printTableStaticdBlock(int number){

        synchronized (StaticExclusive.class){
            for(int i=1;i<=10;i++){
                System.out.println(currentThread()+"->sBlock"+number*i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}