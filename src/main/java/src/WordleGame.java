package src;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class WordleGame {
    String word;

    public WordleGame(WordleDictionary dic) throws FileNotFoundException {
        ArrayList<String> wordleWords = new ArrayList<>();
        for (String word : dic.getList()) {
            if (word.length() == 5) {
                wordleWords.add(word);
            }
        }

        Random random = new Random();
        int ran = random.nextInt(wordleWords.size());
        word = wordleWords.get(ran);
    }

    public CharResult[] guess(String guessString) {
        CharResult[] results = new CharResult[]{
                CharResult.NotFound,
                CharResult.NotFound,
                CharResult.NotFound,
                CharResult.NotFound,
                CharResult.NotFound,
        };
        for (int i = 0; i < guessString.length(); i++) {
            if (guessString.substring(i, i + 1).equals(word.substring(i, i + 1))) {
                results[i] = CharResult.Correct;
            } else if (word.indexOf(guessString.substring(i, i + 1)) != -1) {
                results[i] = CharResult.WrongPlace;
            } else {
                results[i] = CharResult.NotFound;
            }
        }
        return results;
    }
}
