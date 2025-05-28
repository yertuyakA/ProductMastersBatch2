package six.medium;

public class Main {

    public static void main(String[] args) {

        WordCounter wordCounter = new WordCounter("words.txt");
        wordCounter.readFromFile();
    }
}
