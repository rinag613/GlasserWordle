package src;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordleDictionaryTest {

    @Test
    void getList() throws FileNotFoundException {
        //given
        WordleDictionary diction = new WordleDictionary();
        //when
        ArrayList<String> dictionary = diction.getList();
        //then
        assertEquals(167964, dictionary.size());

    }

    @Test
    void getDefinition() throws FileNotFoundException {
        //given
        WordleDictionary diction = new WordleDictionary();
        //when
        String definition = diction.getDefinition("formatting");
        //then
        assertEquals("<format=v> [v]", definition);
    }
}