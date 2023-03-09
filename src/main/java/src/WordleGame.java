package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WordleGame {
    private final Random random = new Random();
    String chosenWord;

    public WordleGame(WordleDictionary dictionary) throws IOException {
        ArrayList<String> chooseFrom = new ArrayList<>();

        for (String word : dictionary.getList()) {
            if (word.length() == 5) {
                chooseFrom.add(word);
            }
        }

        int picked = random.nextInt(chooseFrom.size());
        chosenWord = chooseFrom.get(picked);
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
            if (guessString.substring(i, i + 1).equals(chosenWord.substring(i, i + 1))) {
                results[i] = CharResult.Correct;
            } else if (chosenWord.indexOf(guessString.substring(i, i + 1)) != -1) {
                results[i] = CharResult.WrongPlace;
            } else {
                results[i] = CharResult.NotFound;
            }
        }
        return results;
    }
}
