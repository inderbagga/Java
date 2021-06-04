package strings;

import java.util.ArrayList;
import java.util.List;

public class DuplicateStrings {

    public static void main(String[] arg) {

        String word = "Shameless!";

        int comparator=0;
        int occurence[] = new int[word.length()];
        List duplicates = new ArrayList<Character>();

        System.out.println("Duplicate characters in: " + word);

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
}