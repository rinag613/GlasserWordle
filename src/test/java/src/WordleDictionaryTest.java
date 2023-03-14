package src;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordleDictionaryTest {

    @Test
    void getList() throws IOException {
        //given
        WordleDictionary diction = new WordleDictionary();
        //when
        Set<String> dictionary = diction.getList();
        //then
        assertEquals(167964, dictionary.size());

    }

    @Test
    void getDefinition() throws IOException {
        //given
        WordleDictionary diction = new WordleDictionary();
        //when
        String definition = diction.getDefinition("formatting");
        //then
        assertEquals("<format=v> [v]", definition);
    }
}