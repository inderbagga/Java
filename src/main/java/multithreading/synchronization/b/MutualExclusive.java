package multithreading.synchronization.b;

import static java.lang.Thread.currentThread;

public class MutualExclusive {

    public static void main(String[] args){

        MutualExclusive sharableObject=new MutualExclusive();

        DummyWorker worker1=new DummyWorker(sharableObject,1);
        DummyWorker worker2=new DummyWorker(sharableObject,2);

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
}

class DummyWorker extends Thread{

    int number;
    MutualExclusive object;

    public DummyWorker(MutualExclusive object,int number){
        this.object=object;
        this.number=number;
    }

    @Override
    public void run() {

        object.printTableSharedMethod(number);
    }
}