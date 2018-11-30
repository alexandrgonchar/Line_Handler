package resources_handlers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileResourcesHandler implements ResourcesHandler {
    String path;

    public FileResourcesHandler (String path) {
        this.path = path;
    }

    @Override
    public List<String> getResources() {
        ArrayList<String> result = new ArrayList<>();

        try {
            Files.lines(Paths.get(path), StandardCharsets.UTF_8).forEach(result::add);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
