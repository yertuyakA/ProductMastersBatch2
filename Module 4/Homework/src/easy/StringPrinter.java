package easy;

public class StringPrinter<T extends String> implements Printer<T> {

    @Override
    public void print(T value) {
        System.out.println(value);
    }
}
