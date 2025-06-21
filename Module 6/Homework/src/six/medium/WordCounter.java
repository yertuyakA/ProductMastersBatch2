package six.medium;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordCounter {

    private final String filePath;

    WordCounter (String filePath) {
        this.filePath = filePath;
    }

    public void readFromFile() {
        Set<String> uniqueWords = new HashSet<>();
        Map<String, Integer> wordFrequency = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-z0-9 ]", "").split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        uniqueWords.add(word);
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }

            System.out.println("Uniqe words:");
            for (String word : uniqueWords) {
                System.out.println(word);
            }

            System.out.println("\nFrequency of words:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (IOException e) {
            System.err.println("Can not read from a file: " + e.getMessage());
        }
    }
}
