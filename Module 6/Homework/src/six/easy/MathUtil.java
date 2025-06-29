package six.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MathUtil<T extends Number & Comparable<T>> {

    private List<T> numbers;

    MathUtil(List<T> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public T getMin() {
        return Collections.min(numbers);
    }

    public T findMax() {
        return Collections.max(numbers);
    }

    public List<T> sortAscending() {
        List<T> sorted = new ArrayList<>(numbers);
        Collections.sort(sorted);
        return sorted;
    }

    public List<T> sortDescending() {
        List<T> sorted = new ArrayList<>(numbers);
        sorted.sort(Collections.reverseOrder());
        return sorted;
    }

    public boolean contains(T value) {
        return numbers.contains(value);
    }

    public List<T> filterGreaterThan(T number) {
        List<T> filtered = new ArrayList<>();
        for (T num : numbers) {
            if (num.compareTo(number) > 0) {
                filtered.add(num);
            }
        }
        return filtered;
    }

    public double sumAll() {
        return numbers.stream()
                .mapToDouble(Number::doubleValue)
                .sum();
    }
}
