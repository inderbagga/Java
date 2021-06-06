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

    P(int id){
        this.id=id;
    }

    @Override
    public void run() {

        switch (id){

            case 1: for(int i=1;i<6;i++){
                System.out.println("p1->"+i);
            }
            break;

            case 2: for(int i=6;i<11;i++){
                System.out.println("p2->"+i);
            }
            break;

        }
    }
}