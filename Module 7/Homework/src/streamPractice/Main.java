package streamPractice;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        repetitiveWords();
    }

    private static void sortEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> even = numbers.stream()
                .filter(i -> i % 2 == 0)
                .toList();
        System.out.println(even);
    }

    private static void stringLengthInsideList() {
        List<String> words = List.of("Java", "Python", "JavaScript", "C++", "C#", "C", "Golang", "Ruby");
        List<Integer> wordsLength = words.stream()
                .map(String::length)
                .toList();

        System.out.println(wordsLength);
    }

    private static void sortInDecreasingOrder() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> sorted = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(sorted);
    }

    private static void groupStringByLength() {
        List<String> words = List.of("Java", "Python", "JavaScript", "C++", "C#", "C", "Golang", "Ruby");
        Map<Integer, List<String>> groupedWords = words.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(groupedWords);
    }

    private static void sum() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int sum = numbers.stream()
                .reduce(Integer::sum)
                .get();
        System.out.println(sum);
    }

    private static void avg() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int avg = numbers.stream()
                .reduce(Integer::sum)
                .get() / numbers.size();
        System.out.println(avg);
    }

    private static void minAndMax() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int min = numbers.stream()
                .reduce(Integer::min)
                .get();
        int max = numbers.stream()
                        .max(Integer::compareTo).orElse(-1);

        System.out.println(min);
        System.out.println(max);
    }

    private static <T extends Number> void firstEvenNumber(List<T> numbers) {
        Optional<Integer> num = numbers.stream()
                .map(Number::intValue)
                .filter(i -> i % 2 == 0)
                .findFirst();
        num.ifPresent(System.out::println);
    }

    private static void combineStrings() {
        List<String> words = List.of("Java", "Python", "JavaScript", "C++", "C#", "C", "Golang", "Ruby");
        String oneLine = words.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println(oneLine);
    }

    private static void distinctValues() {
        List<Integer> numbers = Arrays.asList(1, 1, 1, 2, 3, 4, 5, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> distinctValues = numbers.stream()
                .distinct().toList();
        System.out.println(distinctValues);
    }

    private static void repetitiveWords() {
        List<String> words = List.of("Hello Java", "Hello java", "Hello JavA", "Said", "said", "aiD", "Python");
        Set<String> uniqueWords = words.stream()
                .map(w -> w.split(" "))
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
        System.out.println(uniqueWords);
    }


}
