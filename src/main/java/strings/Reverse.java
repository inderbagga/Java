package strings;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class Reverse {

    public static void main(String[] args){

        String adjective="Grateful";
        String name="Inder Bagga";

        reverseInCamel(adjective.toLowerCase());
        reverseInCamel(name.toLowerCase());

        reverseInBytes(adjective);

        System.out.println(new StringBuilder(adjective).reverse());
        System.out.println(new StringBuffer(adjective).reverse());

        reverseBySwap(adjective);

        reverseByCollections(adjective);
    }

    private static void reverseByCollections(String adjective) {

        List<Character> characterList= adjective.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        Collections.reverse(characterList);

        ListIterator<Character> iterator=characterList.listIterator();

        while(iterator.hasNext())
            System.out.print(iterator.next());

    }

    private static void reverseBySwap(String input) {

        int left=0;
        int right=input.length()-1;
        char[] swap=input.toCharArray();

        for(left=0;left<right;left++,right--){
            swap[left]=swap[right];
            swap[right]=input.charAt(left);
        }

        System.out.println(String.valueOf(swap));
    }

    private static void reverseInBytes(String adjective) {

        byte[] inBytes=adjective.getBytes();
        byte[] revBytes=new byte[inBytes.length];


        for(int i=0;i<inBytes.length;i++){
            revBytes[i]=inBytes[inBytes.length-1-i];
        }

        System.out.println(new String(revBytes));
    }

    private static void reverseInCamel(String input) {

        String output="";

        for(int i=input.length()-1;i>=0;i--){
            output=output.concat(String.valueOf(input.charAt(i)));
        }

        if(input.contains(" ")){

            int position=input.indexOf(" ")+1;

            System.out.println(output.substring(0,1).toUpperCase()+
                    output.substring(1,position)+
                    output.substring(position,position+1).toUpperCase()+
                    output.substring(position+1,output.length()));
        }
        else System.out.println(output.substring(0,1).toUpperCase()+
                output.substring(1,output.length()));
    }
}
