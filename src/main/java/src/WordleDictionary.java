package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordleDictionary {
    public ArrayList<String> words;
    public ArrayList<String> definitions;

    public WordleDictionary() throws FileNotFoundException {
        File file = new File("src/main/java/src/dictionary.txt");
        words = new ArrayList<>();
        definitions = new ArrayList<>();
        Scanner dictionary = new Scanner(file);
        String line = dictionary.nextLine();
        while (dictionary.hasNext()) {
            String[] currLine = dictionary.nextLine().split(" ", 2);
            words.add(currLine[0]);
            if (currLine.length > 1) {
                words.add(currLine[1]);
            } else {
                words.add(" ");
            }

        }
    }

    public ArrayList<String> getList() {
        return this.words;
    }

    public String getDefinition(String word) {
        String definition = "";

        int idx = words.indexOf(word.toUpperCase());
        if (idx == -1) {
            return null;
        } else {
            return definitions.get(idx);
        }
    }
}
