package line_handlers;

import resources_handlers.ResourcesHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AmountOfCharHandler implements LineHandler {
    private char ch;
    private Map<String, Long> resultMap = new HashMap<>();

    public AmountOfCharHandler(char ch, ResourcesHandler handler) {
       try {
           this.ch = ch;

           for (String string : handler.getResources())
               if (string != null) handleLine(string);

       } catch (NullPointerException e) {
           System.out.println("Empty resources handler in AmountOfCharHandler!");
       }
    }

    @Override
    public void handleLine (String line) {
        for (String str : line.split(" ")) {
            str = str.replaceAll("\\W","");
            long occurrencesCount = str.chars().filter(c -> c == ch).count();

            resultMap.put(str, occurrencesCount);
        }
    }

    @Override
    public void printResult() {
        long value = resultMap.entrySet().iterator().next().getValue();
        long count = resultMap.entrySet()
                .stream()
                .filter(stringLongEntry -> stringLongEntry.getValue() != value)
                .count();

        if (count > 0) {
            resultMap.entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .forEach(System.out::println);
        } else {
            resultMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(System.out::println);
        }
    }

    public Map<String, Long> getResultMap() {
        return resultMap;
    }
}
