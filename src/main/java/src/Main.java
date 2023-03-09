package src;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, FileNotFoundException {

        WordleDictionary dictionary = new WordleDictionary();
        WordleGame game = new WordleGame(dictionary);

        WordleGameFrame frame = new WordleGameFrame(game, dictionary);
        frame.setVisible(true);
    }
}
