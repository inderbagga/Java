package multithreading.synchronization;

public class MutualExclusive {


    public static void main(String[] args){

        MutualExclusive sharableObject=new MutualExclusive();

        DummyWorker worker1=new DummyWorker(sharableObject,5);
        DummyWorker worker2=new DummyWorker(sharableObject,9);

        worker1.start();
        worker2.start();

        BlockWorker worker3=new BlockWorker(sharableObject,50);
        BlockWorker worker4=new BlockWorker(sharableObject,90);

        worker3.start();
        worker4.start();

    }

    //removing synchronized will display the execution of both worker threads.
    synchronized protected void printTableMethod(int number){

        for(int i=1;i<=10;i++){
            System.out.println(number*i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void printTableBlock(int number){

        synchronized (this){
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
        object.printTableMethod(number);
    }
}

class BlockWorker extends Thread{

    int number;
     MutualExclusive object;

    public BlockWorker(MutualExclusive object,int number){
        this.object=object;
        this.number=number;
    }

    @Override
    public void run() {
        object.printTableBlock(number);
    }
}