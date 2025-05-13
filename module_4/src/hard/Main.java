package hard;

public class Main {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>("Hello");
        System.out.println("Content of stringBox: " + stringBox.getItem());
        stringBox.showType();

        Box<MyData> myDataBox = new Box<>(new MyData(42));
        System.out.println("Content of myDataBox: " + myDataBox.getItem());
        myDataBox.showType();

        Box<Integer> intBox = new Box<>(123);
        System.out.println("Content of intBox: " + intBox.getItem());
        intBox.showType();
    }
}
