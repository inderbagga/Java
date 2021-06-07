package multithreading;

public class ShutdownHook {

    public static void main(String[] args){

        Runtime runtime=Runtime.getRuntime();

        runtime.addShutdownHook(new Thread(){

            @Override
            public void run() {

                System.out.println("Starting task..");

                for(int i=1;i<11;i++){
                    System.out.println(i);
                }

                System.out.println("Completed task..");
            }
        });
    }
}
