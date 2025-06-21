package six.easy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        MathUtil<Integer> list = new MathUtil<>(Arrays.asList(4, 1, 6, 7, 3, 9, 14, 65, 10, 2));
        System.out.println("Min: " + list.getMin());
        System.out.println("Max: " + list.findMax());
        System.out.println("Sorted asc: " + list.sortAscending());
        System.out.println("Sorted desc: " + list.sortDescending());
        System.out.println("Contains 7: " + list.contains(7));
        System.out.println("Greater than 4: " + list.filterGreaterThan(4));
        System.out.println("Sum: " + list.sumAll());
    }
}
