package multithreading;

public class Join {

    public static void main(String[] args) {

        T t1=new T(1);
        T t2=new T(2);
        T t3=new T(3);

        t1.start();
        try {
            t1.join(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        t3.start();
    }
}

class T extends Thread {

    int id;

    T(int id){
        this.id=id;
    }

    @Override
    public void run() {


        switch (id){

            case 1: for(int i=1;i<11;i++){
                try {
                    Thread.sleep(100);
                    System.out.println("t1->"+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                break;

            case 2: for(int i=11;i<21;i++){
                try {
                    Thread.sleep(100);
                    System.out.println("t2->"+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                break;

            case 3: for(int i=21;i<31;i++){
                try {
                    Thread.sleep(100);
                    System.out.println("t3->"+i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                break;
        }
    }
}