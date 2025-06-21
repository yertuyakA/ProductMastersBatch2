package five.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> numbers = getInputNumbers();
        printList(numbers);
        List<Integer> result = removeDuplicates(numbers);
        printList(result);

    }

    public static List<Integer> removeDuplicates(List<Integer> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

    public static List<Integer> getInputNumbers() {
        List<Integer> list = new ArrayList<>();
        System.out.print("Enter any int numbers: ");
        String numbers = sc.nextLine().trim();
        if(numbers.isEmpty()) {
            System.out.println("No numbers were provided.");
            return list;
        }

        for(String num : numbers.split("\\s+")) {
            list.add(Integer.parseInt(num));
        }
        return list;
    }

    public static <T> void printList(List<T> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        System.out.print("\nPrinting numbers: ");
        for(T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
