package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Words {
    List<String> words = new ArrayList<>();

    public void addWord(String word) {
        if (word.strip().contains(" ")) {
            throw new IllegalArgumentException("It should be one word!");
        }
        if (!word.equals(word.toLowerCase())) {
            throw new IllegalArgumentException("Word should be lower case!");
        }
        words.add(word);
    }

    public boolean isThereAWordTwice() {
        List<String> sorted = new ArrayList<>(words);
        Collections.sort(sorted);
        int counter = 0;
        String tmpWord = "";
        for (String word : sorted) {
            counter = tmpWord.equals(word) ? counter + 1 : 1;
            if (counter > 1) {
                return true;
            }
            tmpWord = word;
        }
        return false;
    }

    public List<String> getWords() {
        return words;
    }
}
