package line_handlers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Locale;

import static org.junit.Assert.*;

public class MaxPalindromeHandlerTest {
    private MaxPalindromeHandler maxPalindromeHandler;


    @Before
    public void setUp() throws Exception {
        maxPalindromeHandler = new MaxPalindromeHandler(() -> {
            ArrayList<String> result = new ArrayList<>();
            result.add(null);
            result.add("aaa bab dfdfsf sdfser a b c ;''p[[sdf[2349250");
            result.add(null);
            result.add("AAAAAAAaA Abnt");
            result.add("1221 000 98 99");

            return result;
        });
    }

    @After
    public void tearDown() throws Exception {
        maxPalindromeHandler = null;
    }

    @Test
    public void handleLine() {
        assertEquals(6, maxPalindromeHandler.getPalindromes().size());

        for (String string : maxPalindromeHandler.getPalindromes()) {
            StringBuilder reverseString = new StringBuilder(string);
            reverseString.reverse();

            assertEquals(string.toUpperCase(Locale.ENGLISH), reverseString.toString().toUpperCase(Locale.ENGLISH));
        }
    }
}