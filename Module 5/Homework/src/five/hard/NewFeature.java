package five.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NewFeature {
    private static final Scanner sc = new Scanner(System.in);

    public record DualList<T>(List<T> original, List<T> distinct) {}

    public static void main(String[] args) {
        DualList<Integer> dualList = getInputNumbers();
        printList(dualList.original);
        printList(dualList.distinct);
    }

    public static DualList<Integer> getInputNumbers() {
        List<Integer> original = new ArrayList<>();
        System.out.print("Enter any int numbers: ");
        String numbers = sc.nextLine().trim();
        if(numbers.isEmpty()) {
            System.out.println("No numbers were provided.");
            return new DualList<>(original, original);
        }
        for(String num : numbers.split("\\s+")) {
            original.add(Integer.parseInt(num));
        }
        List<Integer> distinct = original.stream().distinct().collect(Collectors.toList());
        return new DualList<>(original, distinct);
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
