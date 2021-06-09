package multithreading.synchronization.mutualexclusive.b;

import static java.lang.Thread.currentThread;

public class InstanceExclusive {

    public static void main(String[] args){

        InstanceExclusive sharableObject1=new InstanceExclusive();
        InstanceExclusive sharableObject2=new InstanceExclusive();

        iDummyWorker worker1=new iDummyWorker(sharableObject1,1);
        iBlockWorker worker2=new iBlockWorker(sharableObject2,2);

        worker1.setName("worker1");
        worker2.setName("worker2");

        worker1.start();
        worker2.start();
    }

    //removing synchronized will display the execution of both worker threads.
    synchronized protected void printTableSharedMethod(int number){

        for(int i=1;i<=10;i++){
            System.out.println(currentThread()+"->Method"+number*i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //Use of Synchronized block
    protected void printTableSharedBlock(int number){

        synchronized (this){
            for(int i=1;i<=10;i++){
                System.out.println(currentThread()+"->Block"+number*i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

class iDummyWorker extends Thread{

    int number;
    InstanceExclusive object;

    public iDummyWorker(InstanceExclusive object,int number){
        this.object=object;
        this.number=number;
    }

    @Override
    public void run() {

        object.printTableSharedMethod(number);
    }
}

class iBlockWorker extends Thread{

    int number;
    InstanceExclusive object;

    public iBlockWorker(InstanceExclusive object,int number){
        this.object=object;
        this.number=number;
    }

    @Override
    public void run() {
        object.printTableSharedBlock(number);
    }

}