package strings;

public class Equality {

    public static void main(String[] args){

        String str="ABC";
        String object=new String("ABC");

        System.out.println(System.identityHashCode( str ));
        System.out.println(System.identityHashCode( object ));

        System.out.println(str==object);//false; because memory address is different.
        System.out.println(str.equals(object));//true' because contents are same.
    }
}
