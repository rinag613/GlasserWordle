package src;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;

class WordleGameTest {

    @Test
    void guess() throws FileNotFoundException {
        //given
        WordleDictionary dic = Mockito.mock(WordleDictionary.class);
        ArrayList<String> word = new ArrayList<>(List.of("APPLE"));
        //way to program the dictionary to give us what we want
        //do return-what we want it to return when method is called
        //when- put the object that you are using -the mock
        //then the method you are calling
        doReturn(word).when(dic).getList();
        WordleGame game = new WordleGame(dic);
        //when
        CharResult[] result = game.guess("APPLE");
        //then
        CharResult[] expected = {CharResult.Correct,
                CharResult.Correct,
                CharResult.Correct,
                CharResult.Correct,
                CharResult.Correct,};

        assertArrayEquals(expected, result);
    }

    @Test
    void guess2() throws FileNotFoundException {
        //given
        WordleDictionary dic = Mockito.mock(WordleDictionary.class);
        ArrayList<String> word = new ArrayList<>(List.of("APPLE"));
        //way to program the dictionary to give us what we want
        //do return-what we want it to return when method is called
        //when- put the object that you are using -the mock
        //then the method you are calling
        doReturn(word).when(dic).getList();
        WordleGame game = new WordleGame(dic);
        //when
        CharResult[] result = game.guess("APELW");
        //then
        CharResult[] expected = {CharResult.Correct,
                CharResult.Correct,
                CharResult.WrongPlace,
                CharResult.Correct,
                CharResult.NotFound,};

        assertArrayEquals(expected, result);
    }
}