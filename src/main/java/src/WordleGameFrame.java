package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WordleGameFrame extends JFrame {

    int numGuesses = 0;
    int keysTyped = 0;
    private WordleController controler;
    private JButton[] keyboard = new JButton[26];
    private JLabel[][] blanks = {{new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-")}, {new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-")}, {new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-")}, {new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-")}, {new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-")}, {new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-")}};

    public WordleGameFrame(WordleGame wordleGame, WordleDictionary wordleDictionary) {

        controler = new WordleController(wordleGame, wordleDictionary, keyboard);

        JFrame frameObj = new JFrame();
        frameObj.setLayout(new GridLayout(6, 5));
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 5; col++) {
                frameObj.add(blanks[row][col]);
                blanks[row][col].setHorizontalAlignment(SwingConstants.CENTER);
                blanks[row][col].setVerticalAlignment(SwingConstants.CENTER);
            }
        }
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (numGuesses < 6 && keysTyped < 5 && !String.valueOf(e.getKeyChar()).equals("\b")) {
                    (blanks[numGuesses][keysTyped]).setText(String.valueOf(e.getKeyChar()).toUpperCase());
                }
                keysTyped += 1;
                char character = e.getKeyChar();
                if (Character.isAlphabetic(character)) {
                    controler.addLetter(String.valueOf(e.getKeyChar()).toUpperCase());
                } else if (String.valueOf(e.getKeyChar()).equals("\b")) {
                    controler.backspace();
                    keysTyped -= 2;
                    (blanks[numGuesses][keysTyped]).setText("");
                } else if (String.valueOf(e.getKeyChar()).equals("\n")) {
                    CharResult[] grade = controler.enterGuess();
                    numGuesses += 1;
                    turnColors(grade);
                    keysTyped = 0;
                    controler.resetWord();
                }
            }
        });
        frameObj.setVisible(true);
        frameObj.setSize(300, 300);
        frameObj.setTitle("Wordle Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    private void turnColors(CharResult[] grade) {
        for (int i = 0; i < grade.length; i++) {
            if (grade[i] == CharResult.NotFound) {
                (blanks[numGuesses - 1][i]).setBackground(Color.gray);
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