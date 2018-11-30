import line_handlers.AmountOfCharHandler;
import line_handlers.MaxPalindromeHandler;
import line_handlers.StringReplacerHandler;
import line_handlers.WordsCounterHandler;
import resources_handlers.FileResourcesHandler;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FileResourcesHandler handler = new FileResourcesHandler("/home/azathoth/sdfsdf.txt");

        ArrayList<String> list = new ArrayList<>();
        list.add("Abs");
        list.add("fff");
        list.add("pop");
        WordsCounterHandler counter = new WordsCounterHandler(list, handler);
        counter.printResult();

        MaxPalindromeHandler palindrome = new MaxPalindromeHandler(handler);
        palindrome.printResult();

        StringReplacerHandler replacer = new StringReplacerHandler(3, "RTXOPR", handler);
        replacer.printResult();

        AmountOfCharHandler charHandler = new AmountOfCharHandler('d', handler);
        charHandler.printResult();
    }
}
