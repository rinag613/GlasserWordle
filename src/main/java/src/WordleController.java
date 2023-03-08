package src;

import javax.swing.*;

public class WordleController {
    private WordleGame wordleGame;
    private WordleDictionary wordleDictionary;
    //  private JLabel[][] labels;
    private JButton[] keyboard;
    private String wordGuessed = "";

    public WordleController(WordleGame wordleGame, WordleDictionary wordleDictionary, JButton[] keyboard) {
        this.wordleGame = wordleGame;
        this.wordleDictionary = wordleDictionary;
        // this.labels = labels;
        this.keyboard = keyboard;
    }

    /**
     * Called when you type the letter in or press a letter on the onscreen keyboard
     *
     * @param letter
     */
    public void addLetter(String letter) {
        wordGuessed = wordGuessed + letter;
    }

    public CharResult[] enterGuess() {
        System.out.println(wordGuessed);

        CharResult[] answer = wordleGame.guess(wordGuessed);
        return answer;
    }

    public void backspace() {
        wordGuessed = wordGuessed.substring(0, wordGuessed.length() - 1);
    }

    public void resetWord() {
        wordGuessed = "";
    }
}
