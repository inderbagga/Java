package multithreading;

import static java.lang.Thread.sleep;

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

        for(int i=1;i<=100;i++){

            if(i>25&&i<76) {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else System.out.println(Thread.currentThread()+":"+i);
        }
    }
}

class DEF implements Runnable {

    @Override
    public void run() {

        for(int i=1;i<=100;i++){

            if(i>25&&i<76)System.out.println(Thread.currentThread()+":"+i);
            else {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
