package src;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        WordleDictionary diction = new WordleDictionary("C:\\Users\\User\\Downloads\\dictionary.txt");
//        System.out.println(diction.getDefinition("ZOOGEOGRAPHICA"));
//
//        ArrayList<String> dic = diction.getList();
//        for (int i = 0; i < dic.size(); i++) {
//            System.out.println(dic.get(i));
//        }

        WordleGame game = new WordleGame();
        //when
        CharResult[] result = game.guess("FOGYJ");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
