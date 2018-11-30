package line_handlers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import resources_handlers.ResourcesHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class AmountOfCharHandlerTest {
    private AmountOfCharHandler amountOfCharHandler;

    @Before
    public void setUp() throws Exception {
        amountOfCharHandler = new AmountOfCharHandler('a', () -> {
            ArrayList<String> result = new ArrayList<>();
            result.add(null);
            result.add("aaa bab dfdfsf sdfser 1232143a ;''p[[sdf[2349250");
            result.add(null);
            result.add("AAAAAAAAA Abnt");

            return result;
        });
    }

    @After
    public void tearDown() throws Exception {
        amountOfCharHandler = null;
    }

    @Test
    public void handleLine() {
        for (Map.Entry<String, Long> entry : amountOfCharHandler.getResultMap().entrySet()) {
            if (entry.getKey().contains("a")) assertTrue(entry.getValue() != 0L);
            else assertTrue(entry.getValue() == 0L);
        }
    }
}