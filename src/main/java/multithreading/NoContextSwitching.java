package multithreading;

public class NoContextSwitching {

    public static void main(String[]args){

        ABC threadABC=new ABC("ABC");

        DEF runnableDEF=new DEF();
        Thread threadDEF=new Thread(runnableDEF,"DEF");

        System.out.println("threadABC.getState() -> "+ threadABC.getState());

        //will be treated as normal object not thread object.
        threadABC.run();
        threadDEF.run();

        System.out.println("threadDEF.getState() -> "+ threadDEF.getState());
    }
}
