package multithreading.synchronization;

public class SynchronizedMethod {


    public static void main(String[] args){

        SynchronizedMethod sharableObject=new SynchronizedMethod();

        DummyWorker worker1=new DummyWorker(sharableObject,5);
        DummyWorker worker2=new DummyWorker(sharableObject,9);

        worker1.start();
        worker2.start();

    }

    //removing synchronized will display the execution of both worker threads.
    synchronized protected void printTable(int number){

        for(int i=1;i<=10;i++){
            System.out.println(number*i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

 class DummyWorker extends Thread{

    int number;
    SynchronizedMethod object;

    public DummyWorker(SynchronizedMethod object,int number){
        this.object=object;
        this.number=number;
    }

    @Override
    public void run() {
        object.printTable(number);
    }
}