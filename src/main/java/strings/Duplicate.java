package strings;

import java.util.ArrayList;
import java.util.List;

public class Duplicate {

    public static void main(String[] arg) {

        String word = "Shameless!";

        duplicateLetterCount(word);
        duplicateLetters(word);
    }


    public static void duplicateLetterCount(String word) {

        int comparator=0;
        int occurence[] = new int[word.length()];
        List duplicates = new ArrayList<Character>();

        System.out.println("==== Duplicate characters with count in: " + word+" ====");

        for (int i = 0; i < word.length(); i++,comparator++) {

            //every letter is present once by default
            occurence[i] = 1;

            for (int j = i+1; j < word.length() && i != j; j++,comparator++) {

                if (word.charAt(i) == word.charAt(j)) {
                    occurence[i] = occurence[i] + 1;
                }
            }
        }

        System.out.println("Iterations performed during stage1: "+ comparator);

        for (int k =0;k< occurence.length - 1;  k++,comparator++) {
            if (occurence[k] > 1 && !duplicates.contains(word.charAt(k))) {
                duplicates.add(word.charAt(k));
                System.out.println("The duplicate character " + word.charAt(k) + " appeared " + occurence[k] + " times.");
            }
        }

            System.out.println("Total iterations executed after stage2: "+ comparator);

        duplicates.clear();
        occurence=null;
    }

    public static void duplicateLetters(String string1) {

        int count;

        //Converts given string into character array
        char string[] = string1.toCharArray();

        System.out.println("===== Duplicate characters in a given string: =====");
        //Counts each character present in the string
        for(int i = 0; i <string.length; i++) {
            count = 1;
            for(int j = i+1; j <string.length; j++) {
                if(string[i] == string[j] && string[i] != ' ') {
                    count++;
                    //Set string[j] to 0 to avoid printing visited character
                    string[j] = '0';
                }
            }
            //A character is considered as duplicate if count is greater than 1
            if(count > 1 && string[i] != '0')
                System.out.println(string[i]);
        }
    }
}