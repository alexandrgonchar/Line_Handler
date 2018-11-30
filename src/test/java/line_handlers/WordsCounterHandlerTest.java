package line_handlers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.*;

public class WordsCounterHandlerTest {
    private WordsCounterHandler wordsCounterHandler;
    private ArrayList<String> words;

    @Before
    public void setUp() throws Exception {
        words = new ArrayList<>();
        words.add(null);
        words.add("aaa");
        words.add("bbb");

        wordsCounterHandler = new WordsCounterHandler(words, () -> {
            ArrayList<String> result = new ArrayList<>();
            result.add(null);
            result.add("aaa bab aaa bbb a b c ;''p[[sdf[2349250");
            result.add(null);
            result.add("AAA BBB AAABBB");
            result.add("1221 000 98 99");

            return result;
        });
    }

    @After
    public void tearDown() throws Exception {
        wordsCounterHandler = null;
        words = null;
    }

    @Test
    public void handleLine() {
        for (Map.Entry<String, Integer> entry : wordsCounterHandler.getResultMap().entrySet()) {
            assertNotNull(entry.getKey());
            if (entry.getKey().equals("aaa")) assertEquals(new Integer(3), entry.getValue());
            else assertEquals(new Integer(2), entry.getValue());
        }
    }
}