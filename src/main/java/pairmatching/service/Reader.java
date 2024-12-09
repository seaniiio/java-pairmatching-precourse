package pairmatching.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private static final String FRONTEND_CREW_FILE_PATH = "src/main/resources/frontend-crew.md";
    private static final String BACKEND_CREW_FILE_PATH = "src/main/resources/backend-crew.md";

    public static List<String> readFrontendCrew() {
        return readFile(FRONTEND_CREW_FILE_PATH);
    }

    public static List<String> readBackendCrew() {
        return readFile(BACKEND_CREW_FILE_PATH);
    }

    private static List<String> readFile(String filePath) {
        List<String> contents = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            readLine(br, contents);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contents;
    }

    private static void readLine(BufferedReader br, List<String> contents) throws IOException {
        String line;

        while ((line = br.readLine()) != null) {
            contents.add(line);
        }
    }
}
