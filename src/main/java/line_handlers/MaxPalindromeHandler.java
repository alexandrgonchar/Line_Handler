package line_handlers;

import resources_handlers.ResourcesHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class MaxPalindromeHandler implements LineHandler {
    private ArrayList<String> palindromes = new ArrayList<>();

    public MaxPalindromeHandler(ResourcesHandler handler) {
        try {
            for (String string : handler.getResources())
                if (string != null) handleLine(string);
        } catch (NullPointerException e) {
            System.out.println("Empty resources handler in MaxPalindromeHandler!");
        }
    }

    @Override
    public void handleLine (String line) {
        for (String str : line.split(" ")) {
            if (str.length() > 1) {
                str = str.replaceAll("\\W", "");

                String reverseStr = new StringBuffer(str).reverse().toString();

                if (str.equalsIgnoreCase(reverseStr)) palindromes.add(str);
            }
        }
    }

    @Override
    public void printResult() {
        try {
            System.out.println(Collections.max(palindromes, Comparator.comparingInt(String::length)));
        } catch (NoSuchElementException e) {
            System.out.println("Find no palindrome. List empty");
        }
    }

    public ArrayList<String> getPalindromes() {
        return palindromes;
    }
}
