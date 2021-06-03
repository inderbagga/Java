package strings;

import java.util.ArrayList;
import java.util.List;

public class DuplicateStrings {

    public static void main(String[] arg) {

        String word = "Shameless!";

        System.out.println("Duplicate characters in: " + word);

        int occurence[] = new int[word.length()];
        List duplicates = new ArrayList<Character>();

        for (int i = 0; i < word.length(); i++) {

            //every letter is present once by default
            occurence[i] = 1;

            for (int j = 0; j < word.length() && i != j; j++) {

                if (word.charAt(i) == word.charAt(j)) {
                    //increase duplicate occurence
                    occurence[i] = occurence[i] + 1;
                }
            }
        }

        for (int i = occurence.length - 1; i >= 0; i--) {
            if (occurence[i] > 1 && !duplicates.contains(word.charAt(i))) {
                duplicates.add(word.charAt(i));
                System.out.println("The duplicate character " + word.charAt(i) + " appeared " + occurence[i] + " times.");
            }
        }

        duplicates.clear();
        occurence=null;
    }
}