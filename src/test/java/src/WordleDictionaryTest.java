package src;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WordleDictionaryTest {

    @Test
    void getList() throws FileNotFoundException {
        //given
        WordleDictionary diction = new WordleDictionary("C:\\Users\\User\\Downloads\\dictionary.txt");
        //when
        ArrayList<String> dictionary = diction.getList();
        //then
        assertEquals(167964, dictionary.size());
        //167964

    }

    @Test
    void getDefinition() throws FileNotFoundException {
        //given
        WordleDictionary diction = new WordleDictionary("C:\\Users\\User\\Downloads\\dictionary.txt");
        //when
        String definition = diction.getDefinition("formatting");
        //then
        assertEquals("<format=v> [v]",definition);
    }
}