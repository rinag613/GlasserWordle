package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

public class WordleGameFrame extends JFrame {

    int numGuesses = 0;
    int keysTyped = 0;
    private WordleController controller;
    private JFrame mainFrame;
    private ArrayList<String> alpha1 = new ArrayList<String>(
            Arrays.asList("Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P"));
    private ArrayList<String> alpha2 = new ArrayList<String>(
            Arrays.asList("A", "S", "D", "F", "G", "H", "J", "K", "L"));
    private ArrayList<String> alpha3 = new ArrayList<String>(
            Arrays.asList("Z", "X", "C", "V", "B", "N", "M"));

    private JButton[] keyboard1 = {new JButton("Q"), new JButton("W"), new JButton("E"), new JButton("R"), new JButton("T"), new JButton("Y"), new JButton("U"), new JButton("I"), new JButton("O"), new JButton("P")};
    private JButton[] keyboard2 = {new JButton("A"), new JButton("S"), new JButton("D"), new JButton("F"), new JButton("G"), new JButton("H"), new JButton("J"), new JButton("K"), new JButton("L")};
    private JButton[] keyboard3 = {new JButton("Z"), new JButton("X"), new JButton("C"), new JButton("V"), new JButton("B"), new JButton("N"), new JButton("M")};

    private JLabel[][] blanks = new JLabel[6][5];

    public WordleGameFrame(WordleGame wordleGame, WordleDictionary wordleDictionary) {

        controller = new WordleController(wordleGame, wordleDictionary, mainFrame, blanks, keyboard1, keyboard2, keyboard3);

        mainFrame = new JFrame("Wordle");
        mainFrame.setLayout(new BorderLayout());

        JPanel keyboardFrame = new JPanel();
        keyboardFrame.setLayout(new BorderLayout());

        JPanel frame = new JPanel();
        frame.setLayout(new GridLayout(1, 10));
        for (int i = 0; i < keyboard1.length; i++) {
            int ii = i;
            frame.add(keyboard1[i]);
            keyboard1[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    mainFrame.requestFocus();
                    String letter = keyboard1[ii].getText();
                    controller.addLetter(letter, ii, 1);
                }
            });
        }
        JPanel frame2 = new JPanel();
        frame2.setLayout(new GridLayout(1, 11));
        JButton enter = new JButton("ENTER");
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.requestFocus();
                controller.enterGuess();
            }
        });
        for (int i = 0; i < keyboard2.length; i++) {
            int ii = i;
            frame2.add(keyboard2[i]);
            keyboard2[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    mainFrame.requestFocus();
                    String letter = keyboard2[ii].getText();
                    controller.addLetter(letter, ii, 2);
                }
            });
        }
        JPanel frame3 = new JPanel();
        frame3.setLayout(new GridLayout(1, 10));
        for (int i = 0; i < keyboard3.length; i++) {
            int ii = i;
            frame3.add(keyboard3[i]);
            keyboard3[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    mainFrame.requestFocus();
                    String letter = keyboard3[ii].getText();
                    controller.addLetter(letter, ii, 3);
                }
            });
        }
        JButton backspace = new JButton("BACKSPACE");
        backspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.requestFocus();
                controller.backspace();
            }
        });
        JPanel frameObj = new JPanel();
        frameObj.setLayout(new GridLayout(6, 5));
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 5; col++) {
                (blanks[row][col]) = new JLabel("");
                frameObj.add((blanks[row][col]));
                blanks[row][col].setHorizontalAlignment(SwingConstants.CENTER);
                blanks[row][col].setPreferredSize(new Dimension(50, 50));
                blanks[row][col].setBorder(BorderFactory.createLineBorder(Color.black));
                blanks[row][col].setVerticalAlignment(SwingConstants.CENTER);
            }
        }
        mainFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                mainFrame.requestFocus();
                char character = e.getKeyChar();
                String letter = String.valueOf(character).toUpperCase();
                if (Character.isAlphabetic(character)) {
                    if (alpha1.indexOf(letter) != -1) {
                        controller.addLetter(letter, alpha1.indexOf(letter), 1);
                    } else if (alpha2.indexOf(letter) != -1) {
                        controller.addLetter(letter, alpha2.indexOf(letter), 2);
                    } else if (alpha3.indexOf(letter) != -1) {
                        controller.addLetter(letter, alpha3.indexOf(letter), 3);
                    }
                } else if (String.valueOf(character).equals("\b")) {
                    controller.backspace();
                } else if (String.valueOf(character).equals("\n")) {
                    controller.enterGuess();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        keyboardFrame.add(frame, NORTH);
        keyboardFrame.add(frame2, BorderLayout.CENTER);
        keyboardFrame.add(frame3, SOUTH);

        frame.setSize(500, 100);
        frame.setVisible(true);

        frame2.setSize(500, 100);
        frame2.setVisible(true);
        frame2.add(enter);

        frame3.add(backspace);
        frame3.setSize(500, 100);
        frame3.setVisible(true);

        frameObj.setVisible(true);
        frameObj.setSize(500, 900);

        mainFrame.setFocusable(true);
        mainFrame.requestFocusInWindow();
        mainFrame.add(keyboardFrame, SOUTH);
        mainFrame.add(frameObj, NORTH);
        mainFrame.setSize(900, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}