package multithreading;

public class GarbageCollection {

    public GarbageCollection(int id){
        this.id=id;
    }

    private int id;

    protected void finalize(){
        System.out.println("Object"+id+" garbage collected!");
    }

    public static void main(String[] args){

        GarbageCollection object1=new GarbageCollection(1);
        GarbageCollection object2=new GarbageCollection(2);
        GarbageCollection object3=new GarbageCollection(3);

        //By assigning a reference to another
        object1=object2;

        //By nulling a reference
        object3=null;

        //By anonymous object:
        new GarbageCollection(4);

        System.gc();
    }
}
