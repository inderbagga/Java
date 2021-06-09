package multithreading.synchronization;

public class DeadLock {

    public static void main(String[] args){

        String resource1="India";
        String resource2="China";

        new Thread("thread1"){

            @Override
            public void run() {

                synchronized (resource1){
                    System.out.println(currentThread() +" acquires lock on "+resource1);

                    try { Thread.sleep(2000);} catch (Exception e) {}

                    synchronized (resource2){
                        System.out.println(currentThread() +" acquires lock on "+resource2);
                    }
                }
            }
        }.start();

        new Thread("thread2"){

            @Override
            public void run() {

                synchronized (resource2){
                    System.out.println(currentThread() +" acquires lock on "+resource2);

                    try { Thread.sleep(2000);} catch (Exception e) {}

                    synchronized (resource1){
                        System.out.println(currentThread() +" acquires lock on "+resource1);
                    }
                }
            }
        }.start();
    }
}
