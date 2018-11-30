package line_handlers;

import resources_handlers.ResourcesHandler;

import java.util.ArrayList;

public class StringReplacerHandler implements LineHandler {

    private ArrayList<String> resultText = new ArrayList<>();
    private String substring;
    private int length;

    public StringReplacerHandler(int length, String substring, ResourcesHandler handler) {
        try {
            this.length = length;
            this.substring = substring;

            for (int i = 0; i < handler.getResources().size(); i++) {
                if (handler.getResources().get(i) != null)
                    handleLine(handler.getResources().get(i));
            }

        } catch (NullPointerException e) {
            System.out.println("Empty resources handler in StringReplacerHandler!");
        }
    }

    @Override
    public void handleLine(String line) {
        StringBuilder resultString = new StringBuilder();

        for (String str : line.split(" ")) {

            if (!str.equals(substring)) {
                if (str.replaceAll("\\W","").length() == length) str = str.replace(str, substring);
            }

            resultString.append(str).append(" ");
        }

        resultText.add(resultString.toString());
    }

    @Override
    public void printResult () {
        for (String line : resultText) {
            System.out.println(line);
        }
    }

    public ArrayList<String> getResultText() {
        return resultText;
    }
}
