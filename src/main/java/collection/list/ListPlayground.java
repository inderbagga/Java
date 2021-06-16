package collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class ListPlayground {

    public static void main(String[] args){

        ArrayList<String> fruits=new ArrayList<String>();
        fruits.add("Mango_");
        fruits.add("Banana_");
        fruits.add("Apple_");

        for(String fruit : fruits) {
            System.out.print(fruit);
        }

        System.out.println("");

        fruits.set(1,"Pomegranate_");
        Collections.sort(fruits);

        fruits.forEach(fruit -> System.out.print(fruit));

        System.out.println("");

        ListIterator listIterator= fruits.listIterator(fruits.size());

        while(listIterator.hasPrevious()){
            System.out.print(listIterator.previous());
        }

        System.out.println("");

        Iterator iterator=fruits.iterator();

        iterator.forEachRemaining( fruit -> {

            System.out.print(fruit);
        });
    }
}
