package src;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class WordleGameTest {

    @Test
    void guess() throws FileNotFoundException {
        //given
        WordleGame game = new WordleGame();
        //when
        CharResult[] result = game.guess("FOGGY");
        //then
        CharResult[] expected = {CharResult.Correct,
                CharResult.Correct,
                CharResult.Correct,
                CharResult.Correct,
                CharResult.Correct,};

        assertEquals(expected);
    }

    private void assertEquals(CharResult[] expected) {
    }
}