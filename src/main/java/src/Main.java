package src;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, FileNotFoundException {

        WordleGame game = new WordleGame();
        WordleDictionary dictionary = new WordleDictionary();

        WordleGameFrame frame = new WordleGameFrame(game, dictionary);
        frame.setVisible(true);
    }
}
