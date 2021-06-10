package multithreading;

public class ReentrantMonitor {

    public static void main(String[] args){

        new Thread(){

            @Override
            public void run() {
                new ReentrantMonitor().MainTask();
            }
        }.start();
    }

    private synchronized void MainTask(){

        System.out.println("Starting main task!");

        SubTask();

        System.out.println("Completing main task!");
    }

    private synchronized void SubTask() {

        System.out.println("Starting subTask!");

        System.out.println("Completing subTask!");
    }
}
