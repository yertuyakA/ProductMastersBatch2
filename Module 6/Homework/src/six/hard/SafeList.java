package six.hard;

import java.util.ArrayList;
import java.util.List;

public class SafeList<T> {

    private List<T> list = new ArrayList<>();

    public boolean add(T value) {
        if (value == null || list.contains(value)) {
            return false;
        }
        return list.add(value);
    }

    public T get(int index) {
        if (index < 0 || index >= list.size()) {
            return null;
        }
        return list.get(index);
    }

    public void print() {
        for (T value : list) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
