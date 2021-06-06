package multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class ThreadPool {


    public static void main(String[] args){

        ExecutorService service= Executors.newFixedThreadPool(2);

        for(int i=1;i<11;i++){

            Runnable worker=new Worker(i);
            service.execute(worker);
        }

        service.shutdown();
    }
}

class Worker implements Runnable{

    int id;

    Worker(int id){
        this.id=id;
    }

    @Override
    public void run() {

        System.out.println(currentThread().getName()+"-> Started"+id);
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(currentThread().getName()+"-> End" + id);
    }
}
