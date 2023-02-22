package src;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class WordleGame {
    String word;
    public WordleGame() throws FileNotFoundException {
//        WordleDictionary dic = new WordleDictionary("C:\\Users\\User\\Downloads\\dictionary.txt");
//        ArrayList<String> dictionary = dic.getList();
//        ArrayList<String> wordleWords = new ArrayList<>();
//        for(int i=0;i<dictionary.size();i++){
//            if(dictionary.get(i).length()==5){
//                wordleWords.add(dictionary.get(i));
//            }
//        }
//        Random random = new Random();
//
//        int ran = random.nextInt(dictionary.size());
//        word = dictionary.get(ran);
        word = "FOGGY";
    }
    public CharResult[] guess(String guessString) {
        CharResult[] results = new CharResult[]{
                CharResult.NotFound,
                CharResult.NotFound,
                CharResult.NotFound,
                CharResult.NotFound,
                CharResult.NotFound,
        };
        for(int i=0;i<guessString.length();i++){
            if(guessString.substring(i,i+1).equals(word.substring(i,i+1))) {
                results[i] = CharResult.Correct;
            }else if(word.indexOf(guessString.substring(i,i+1))!=-1){
                results[i] = CharResult.WrongPlace;
            }else{
                results[i] = CharResult.NotFound;
            }
        }
        return results;
    }
}
