package multithreading;

public class DaemonThread {

    public  static void main(String[] args){

        P p1=new P(1);
        P p2=new P(2);

        p1.setDaemon(true);
        p1.start();
        p2.start();
    }
}
