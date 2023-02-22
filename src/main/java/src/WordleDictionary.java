package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordleDictionary {
    public ArrayList<String> words;
    public ArrayList<String> definitions;

    public WordleDictionary(String pathname) throws FileNotFoundException {
        File file = new File(pathname);
        words = new ArrayList<>();
        definitions = new ArrayList<>();
        Scanner dictionary = new Scanner(file);
        String line = dictionary.nextLine();
        while(dictionary.hasNext()) {
            String[] word = line.split("", 2);
            words.add(word[0]);
            if(word.length==2) {
                definitions.add(word[1]);
            }else{
                definitions.add(null);
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
