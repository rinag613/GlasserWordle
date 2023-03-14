package src;

import javax.swing.*;
import java.awt.*;

public class WordleController {
    JLabel[][] blanks;
    int numGuesses = 0;
    int keysTyped = 0;
    JFrame mainFrame;
    private WordleGame wordleGame;
    private WordleDictionary wordleDictionary;
    private JButton[] keyboard1;
    private JButton[] keyboard2;
    private JButton[] keyboard3;
    private int[] keyboards = new int[5];
    private int[] indexes = new int[5];
    private int numCorrect = 0;
    private String wordGuessed = "";


    public WordleController(WordleGame wordleGame, WordleDictionary wordleDictionary,
                            JFrame mainFrame, JLabel[][] blanks,
                            JButton[] keyboard1, JButton[] keyboard2, JButton[] keyboard3) {
        this.wordleGame = wordleGame;
        this.wordleDictionary = wordleDictionary;
        this.keyboard1 = keyboard1;
        this.mainFrame = mainFrame;
        this.keyboard2 = keyboard2;
        this.keyboard3 = keyboard3;
        this.blanks = blanks;
    }

    public void addLetter(String letter, int index, int keyboardNum) {
        wordGuessed = wordGuessed + letter;
        (blanks[numGuesses][keysTyped]).setText(letter);
        keysTyped += 1;
        keyboards[keysTyped - 1] = keyboardNum;
        indexes[keysTyped - 1] = index;
    }

    public void enterGuess() {
        CharResult[] answer = wordleGame.guess(wordGuessed);
        if (wordleDictionary.getDefinition(wordGuessed) != null && wordGuessed.length() == 5) {
            numGuesses += 1;
            turnColors(answer);
            keysTyped = 0;
            resetWord();
            if (numGuesses == 6) {
                JOptionPane.showMessageDialog(mainFrame, wordleGame.getChosenWord(),
                        "Correct Word", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            if (numCorrect == 5) {
                JOptionPane.showMessageDialog(mainFrame, "You Win!",
                        "Success", JOptionPane.PLAIN_MESSAGE);
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

    public void resetWord() {
        wordGuessed = "";
        keyboards = new int[5];
        indexes = new int[5];
    }

    private void turnColors(CharResult[] grade) {
        for (int i = 0; i < grade.length; i++) {
            if (grade[i] == CharResult.NotFound) {
                blanks[numGuesses - 1][i].setBackground(Color.gray);
                blanks[numGuesses - 1][i].setOpaque(true);
                turnKeyboardColor(grade, i);
            } else if (grade[i] == CharResult.WrongPlace) {
                blanks[numGuesses - 1][i].setBackground(Color.YELLOW);
                blanks[numGuesses - 1][i].setOpaque(true);
                turnKeyboardColor(grade, i);
            } else if (grade[i] == CharResult.Correct) {
                numCorrect++;
                blanks[numGuesses - 1][i].setBackground(Color.GREEN);
                blanks[numGuesses - 1][i].setOpaque(true);
                turnKeyboardColor(grade, i);
            }
        }
    }

    private void turnKeyboardColor(CharResult[] grade, int indexOfGrade) {
        if (grade[indexOfGrade] == CharResult.WrongPlace) {
            if (keyboards[indexOfGrade] == 1) {
                keyboard1[indexes[indexOfGrade]].setBackground(Color.YELLOW);
                keyboard1[indexes[indexOfGrade]].setOpaque(true);
            } else if (keyboards[indexOfGrade] == 2) {
                keyboard2[indexes[indexOfGrade]].setBackground(Color.YELLOW);
                keyboard2[indexes[indexOfGrade]].setOpaque(true);
            } else if (keyboards[indexOfGrade] == 3) {
                keyboard3[indexes[indexOfGrade]].setBackground(Color.YELLOW);
                keyboard3[indexes[indexOfGrade]].setOpaque(true);
            }
        }
        if (grade[indexOfGrade] == CharResult.Correct) {
            if (keyboards[indexOfGrade] == 1) {
                keyboard1[indexes[indexOfGrade]].setBackground(Color.GREEN);
                keyboard1[indexes[indexOfGrade]].setOpaque(true);
            } else if (keyboards[indexOfGrade] == 2) {
                keyboard2[indexes[indexOfGrade]].setBackground(Color.GREEN);
                keyboard2[indexes[indexOfGrade]].setOpaque(true);
            } else if (keyboards[indexOfGrade] == 3) {
                keyboard3[indexes[indexOfGrade]].setBackground(Color.GREEN);
                keyboard3[indexes[indexOfGrade]].setOpaque(true);
            }
        }
        if (grade[indexOfGrade] == CharResult.NotFound) {
            if (keyboards[indexOfGrade] == 1) {
                keyboard1[indexes[indexOfGrade]].setBackground(Color.GRAY);
                keyboard1[indexes[indexOfGrade]].setOpaque(true);
            } else if (keyboards[indexOfGrade] == 2) {
                keyboard2[indexes[indexOfGrade]].setBackground(Color.GRAY);
                keyboard2[indexes[indexOfGrade]].setOpaque(true);
            } else if (keyboards[indexOfGrade] == 3) {
                keyboard3[indexes[indexOfGrade]].setBackground(Color.GRAY);
                keyboard3[indexes[indexOfGrade]].setOpaque(true);
            }
        }
    }
}
