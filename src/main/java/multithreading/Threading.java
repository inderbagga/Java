package multithreading;

public class Threading {

    public static void main(String[]args){

        ABC threadABC=new ABC("ABC");

        DEF runnableDEF=new DEF();
        Thread threadDEF=new Thread(runnableDEF,"DEF");

        System.out.println("threadABC.getState() -> "+ threadABC.getState());

        threadABC.start();
        threadDEF.start();

        System.out.println("threadDEF.getState() -> "+ threadDEF.getState());
    }
}

class ABC extends Thread {

    public ABC(String abc) {
        super(abc);

        System.out.println(super.getName()+ " initialized.");
    }

    @Override
    public void run() {

        for(int i=1;i<=5;i++){
            System.out.println(Thread.currentThread()+":"+i);
        }
    }
}

class DEF implements Runnable {

    @Override
    public void run() {

        for(int i=1;i<=5;i++){
            System.out.println(Thread.currentThread()+":"+i);
        }

    }
}
