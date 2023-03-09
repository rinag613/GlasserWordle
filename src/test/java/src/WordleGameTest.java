package src;

import org.junit.jupiter.api.Test;

import java.io.IOException;

class WordleGameTest {

    @Test
    void guess() throws IOException {
        //given
        WordleGame game = new WordleGame(new WordleDictionary());
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