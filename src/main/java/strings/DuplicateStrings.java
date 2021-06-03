package strings;

import java.util.ArrayList;
import java.util.List;

public class DuplicateStrings {

    public static void main(String[] arg) {

        StringOperations operations=new StringOperations();

        String input="Shameless!";

        System.out.println("Duplicate characters in: "+input);

        operations.duplicateStrings(input.toCharArray());

    }
}

class StringOperations{

    public void duplicateStrings(char[] word){

        int counters[]= new int[word.length];

        for(int i=0;i<word.length;i++){

            counters[i]=1;

            for(int j=0;j<word.length&&i!=j;j++){

                if(word[i]==word[j]){
                    counters[i]=counters[i]+1;
                }
            }
        }

        List duplicates=new ArrayList<Character>();

        for(int i=counters.length-1;i>=0;i--){
            if(counters[i]>1&&!duplicates.contains(word[i])){
                duplicates.add(word[i]);
                System.out.println("The duplicate character "+word[i]+" appeared "+counters[i]+" times.");
            }
        }

        duplicates.clear();
    }
}