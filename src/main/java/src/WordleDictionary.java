package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class WordleDictionary {
    private File file;
    private HashMap<String, String> dictionary;

    public WordleDictionary() throws IOException {
        this.file = new File("src/main/java/src/dictionary.txt");
        dictionary = new HashMap<>();
        loadingDictionary();
    }

    private void loadingDictionary() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {
            String[] currLine = line.split(" ", 2);
            if (currLine.length == 2) {
                dictionary.put(currLine[0], currLine[1]);
            } else {
                dictionary.put(currLine[0].toUpperCase(), "");
            }
        }
    }

    public String getDefinition(String word) {
        String definition = dictionary.get(word.toUpperCase());
        return definition;
    }

    public Set<String> getList() {
        Set<String> words = this.dictionary.keySet();
        return words;
    }
}
