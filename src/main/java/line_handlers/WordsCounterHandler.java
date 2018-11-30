package line_handlers;

import resources_handlers.ResourcesHandler;

import java.util.*;

public class WordsCounterHandler implements LineHandler {

    private ArrayList<String> text;
    private Map<String, Integer> resultMap = new TreeMap<>();

    public WordsCounterHandler (List<String> listOfWords, ResourcesHandler handler) {
        try {
            text = new ArrayList<>(handler.getResources());

            for (String word : listOfWords)
                if (word != null) handleLine(word);

        } catch (NullPointerException e) {
            System.out.println("Empty resources handler in WordsCounterHandler, or empty list of words!");
        }
    }

    @Override
    public void handleLine (String word) {
        int count = 0;

        for (String line : text) {
            if (line != null) {
                for (String string : line.split(" ")) {
                    if (string.equalsIgnoreCase(word)) count++;
                }
            }
        }

        resultMap.put(word, count);
    }

    @Override
    public void printResult () {
        resultMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(System.out::println);
    }

    public Map<String, Integer> getResultMap() {
        return resultMap;
    }
}
