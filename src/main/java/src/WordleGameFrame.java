package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WordleGameFrame extends JFrame {

    int numGuesses = 0;
    int keysTyped = 0;
    private WordleController controller;

    private JButton[] keyboard1 = {new JButton("Q"), new JButton("W"), new JButton("E"), new JButton("R"), new JButton("T"), new JButton("Y"), new JButton("U"), new JButton("I"), new JButton("O"), new JButton("P")};
    private JButton[] keyboard2 = {new JButton("A"), new JButton("S"), new JButton("D"), new JButton("F"), new JButton("G"), new JButton("H"), new JButton("J"), new JButton("K"), new JButton("L")};
    private JButton[] keyboard3 = {new JButton("Z"), new JButton("X"), new JButton("C"), new JButton("V"), new JButton("B"), new JButton("N"), new JButton("M")};

    private JLabel[][] blanks = {{new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-")}, {new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-")}, {new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-")}, {new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-")}, {new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-")}, {new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-"), new JLabel("-")}};

    public WordleGameFrame(WordleGame wordleGame, WordleDictionary wordleDictionary) {

        controller = new WordleController(wordleGame, wordleDictionary, keyboard1);
        JFrame keyboardFrame = new JFrame();
        keyboardFrame.setLayout(new BorderLayout());
        for (int i = 0; i < keyboard1.length; i++) {
            keyboardFrame.add(keyboard1[i], BorderLayout.CENTER);
        }


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
                if (numGuesses < 6 && keysTyped < 5 && !String.valueOf(e.getKeyChar()).equals("\b") && !String.valueOf(e.getKeyChar()).equals("\n")) {
                    (blanks[numGuesses][keysTyped]).setText(String.valueOf(e.getKeyChar()).toUpperCase());
                }
                keysTyped += 1;
                char character = e.getKeyChar();
                if (Character.isAlphabetic(character)) {
                    controller.addLetter(String.valueOf(e.getKeyChar()).toUpperCase());
                } else if (String.valueOf(e.getKeyChar()).equals("\b")) {
                    controller.backspace();
                    keysTyped -= 2;
                    (blanks[numGuesses][keysTyped]).setText("");
                } else if (String.valueOf(e.getKeyChar()).equals("\n")) {
                    if (wordleDictionary.getDefinition(controller.getWordGuessed()) != null) {
                        CharResult[] grade = controller.enterGuess();
                        numGuesses += 1;
                        turnColors(grade);
                        keysTyped = 0;
                        controller.resetWord();

                    }

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