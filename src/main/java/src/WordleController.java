package src;

import javax.swing.*;
import java.awt.*;

public class WordleController {
    JLabel[][] blanks;
    int numGuesses = 0;
    int keysTyped = 0;
    private WordleGame wordleGame;
    private WordleDictionary wordleDictionary;
    private JButton[] keyboard;
    private String wordGuessed = "";


    public WordleController(WordleGame wordleGame, WordleDictionary wordleDictionary, JLabel[][] blanks, JButton[] keyboard) {
        this.wordleGame = wordleGame;
        this.wordleDictionary = wordleDictionary;
        this.keyboard = keyboard;
        this.blanks = blanks;
    }

    /**
     * Called when you type the letter in or press a letter on the onscreen keyboard
     *
     * @param letter
     */
    public void addLetter(String letter) {
        wordGuessed = wordGuessed + letter;
        (blanks[numGuesses][keysTyped]).setText(letter);
        keysTyped += 1;
    }

    public void enterGuess() {
        CharResult[] answer = wordleGame.guess(wordGuessed);
        if (wordleDictionary.getDefinition(wordGuessed) != null && wordGuessed.length() == 5) {
            numGuesses += 1;
            turnColors(answer);
            keysTyped = 0;
            resetWord();

            if (numGuesses == 6) {
                System.exit(0);
            }

        } else {
            clearBoard();
            resetWord();
        }

    }

    public void backspace() {
        wordGuessed = wordGuessed.substring(0, wordGuessed.length() - 1);
        keysTyped -= 1;
        (blanks[numGuesses][keysTyped]).setText("-");

    }

    private void clearBoard() {
        for (int i = 0; i < 5; i++) {
            blanks[numGuesses][i].setText("-");
        }
        keysTyped = 0;
    }

    public String getWordGuessed() {
        return wordGuessed;
    }

    public void resetWord() {
        wordGuessed = "";
    }

    private void turnColors(CharResult[] grade) {
        for (int i = 0; i < grade.length; i++) {
            if (grade[i] == CharResult.NotFound) {
                blanks[numGuesses - 1][i].setBackground(Color.gray);
                blanks[numGuesses - 1][i].setOpaque(true);
            } else if (grade[i] == CharResult.WrongPlace) {
                blanks[numGuesses - 1][i].setBackground(Color.YELLOW);
                blanks[numGuesses - 1][i].setOpaque(true);
            } else if (grade[i] == CharResult.Correct) {
                blanks[numGuesses - 1][i].setBackground(Color.GREEN);
                blanks[numGuesses - 1][i].setOpaque(true);

            }
        }

    }
}
