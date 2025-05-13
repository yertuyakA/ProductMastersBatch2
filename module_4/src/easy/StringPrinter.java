package easy;

public class StringPrinter implements Printer<String> {
    @Override
    public void print(String value) {
        System.out.println(value);
    }
}
