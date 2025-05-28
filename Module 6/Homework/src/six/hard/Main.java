package six.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        SafeList<String> list = new SafeList<>();
        list.add("apple");
        list.add("banana");
        list.add(null);
        list.add("apple");

        list.print();
        System.out.println(list.get(0));
        System.out.println(list.get(5));


        List<Integer> anotherList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 4, 4, 5, 6, 6, 6, 6, 6));
        List<Integer> result = removeDuplicates(anotherList);
        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    public static List<Integer> removeDuplicates(List<Integer> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }
}