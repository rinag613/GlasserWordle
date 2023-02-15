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
        while (true) {
            int i = 0;
            int idx = 0;
            while (i < line.length()) {
                if (line.substring(i, i + 1).equals(" ")) {
                    idx = i;
                    break;
                }
                i++;
            }
            words.add(line.substring(0, idx));
            definitions.add(line.substring(idx+1));
            if(dictionary.hasNext()==false){
                break;
            }
            line = dictionary.nextLine();
        }
    }

    public ArrayList<String> getList() {
        return this.words;
    }
    public String getDefinition(String word) {
        String definition = "";

        int idx = words.indexOf(word.toUpperCase());
        if (idx == -1) {
            return ("Word can not be found in dictionary");
        } else {
            return definitions.get(idx);
        }
    }
}
