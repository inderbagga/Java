package multithreading;

public class InterruptThread {

    public static void main(String[] args){

        Thread worker1=new IWorker();
        Thread worker2=new IWorker();

        worker1.setName("worker1");
        worker2.setName("worker2");

        worker1.start();

        worker1.interrupt();

        worker2.start();

    }
}


class IWorker extends Thread{

    @Override
    public void run() {

        for(int i=1;i<5;i++){

            if(isInterrupted())
                System.out.println(currentThread().getName() + " INTERRUPTED worked "+i+" time.");
            else System.out.println(currentThread().getName() + " NORMAL worked "+i+" time.");
        }
    }
}