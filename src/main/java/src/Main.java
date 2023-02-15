package src;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        WordleDictionary diction = new WordleDictionary("C:\\Users\\User\\Downloads\\dictionary.txt");
        System.out.println(diction.getDefinition("FOG"));

        ArrayList<String> dic = diction.getList();
        for (int i = 0; i < dic.size(); i++) {
            System.out.println(dic.get(i));
        }
    }
}
