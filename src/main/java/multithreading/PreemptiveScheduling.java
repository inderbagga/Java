package multithreading;

public class PreemptiveScheduling {

    public static void main(String[] args) {

        P p1=new P(1);
        P p2=new P(2);

        p1.setPriority(Thread.MIN_PRIORITY);
        p2.setPriority(Thread.MAX_PRIORITY);

        p1.start();
        p2.start();
    }
}

class P extends Thread {

    int id;
    boolean isDaemon;

    P(int id){
        this.id=id;
    }

    @Override
    public void run() {

        if(Thread.currentThread().isDaemon())isDaemon=true;

        switch (id){

            case 1: for(int i=1;i<6;i++){
                System.out.println(isDaemon?"Daemon Thread p1->"+i:"User Thread p1->"+i);
            }
            break;

            case 2: for(int i=6;i<11;i++){
                System.out.println(isDaemon?"Daemon Thread p2->"+i:"User Thread p2->"+i);
            }
            break;

        }
    }
}