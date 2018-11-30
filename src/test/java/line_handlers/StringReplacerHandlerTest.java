package line_handlers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StringReplacerHandlerTest {
    private StringReplacerHandler stringReplacerHandler;

    @Before
    public void setUp() throws Exception {
        stringReplacerHandler = new StringReplacerHandler(3, "WWWWWW", () -> {
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
        stringReplacerHandler = null;
    }

    @Test
    public void handleLine() {
        assertEquals(3, stringReplacerHandler.getResultText().size());

        for (String string : stringReplacerHandler.getResultText()) {
            assertTrue(string.length() != 3);
        }
    }
}